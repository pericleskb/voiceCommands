package com.donkeymonkey.voiceCommands

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val buttons: MutableLiveData<ArrayList<String>> by lazy {
        MutableLiveData<ArrayList<String>>().also {
            loadButtons()
        }
    }

    private fun loadButtons() {

    }

    fun getButtons(): LiveData<ArrayList<String>> {
        return buttons
    }
}