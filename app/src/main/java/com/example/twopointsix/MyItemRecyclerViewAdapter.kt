package com.example.twopointsix

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat


class MyItemRecyclerViewAdapter(
    private val values: Array<String>,
    val context: Context,
    val viewModel: ColorViewModel):
    RecyclerView.Adapter<MyItemRecyclerViewAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_color_list,
            parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            viewModel.setColor("@color/${values.get(position)}")
        }
        holder.bind(values.get(position))
        val resId = context.resources.getIdentifier("@color/${values.get(position)}",
            "id", context.packageName)
        holder.itemView.background = ContextCompat.getDrawable(context, resId)
    }

    override fun getItemCount(): Int = values.size

    class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val content: TextView = itemView.findViewById(R.id.content)

        fun bind(str: String){
            content.text = str
        }
    }

}