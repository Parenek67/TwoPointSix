package com.example.twopointsix

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer


class ColoredFragment : Fragment() {

    private val viewModel: ColorViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_colored, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val textView: TextView = activity!!.findViewById(R.id.textView)
        viewModel.color.observe(this, Observer {
            val resId = context!!.resources.getIdentifier(it,"id", context!!.packageName)
            textView.background = context!!.let { it1 -> ContextCompat.getDrawable(it1, resId) }
        })
    }
}