package com.example.twopointsix

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ColorViewModel: ViewModel() {
    val color = MutableLiveData<String>()

    fun setColor(newColor: String){
        color.value = newColor
    }
}