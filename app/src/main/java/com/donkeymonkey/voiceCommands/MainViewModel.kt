package com.donkeymonkey.voiceCommands

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.donkeymonkey.voicecommandsdata.db.VoiceCommandsDatabase
import com.donkeymonkey.voicecommandsdata.repositories.CommandRepositoryImpl

class MainViewModel(context: Context): ViewModel() {
    private val commandsRepository = CommandRepositoryImpl(
        VoiceCommandsDatabase.getDatabase(context).commandDao()
    )
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