package com.donkeymonkey.voiceCommands

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.donkeymonkey.voicecommandsdata.db.VoiceCommandsDatabase
import com.donkeymonkey.voicecommandsdata.entities.Command
import com.donkeymonkey.voicecommandsdata.repositories.CommandRepositoryImpl

class MainViewModel(context: Context): ViewModel() {
    private val commandsRepository = CommandRepositoryImpl(
        VoiceCommandsDatabase.getDatabase(context).commandDao()
    )
    private val buttons: MutableLiveData<List<Command>> by lazy {
        MutableLiveData<List<Command>>().also {
            loadButtons()
        }
    }

    private suspend fun loadButtons() {
        buttons.postValue(commandsRepository.getCommands().value)
    }

    fun getButtons(): LiveData<List<Command>> {
        return buttons
    }
}