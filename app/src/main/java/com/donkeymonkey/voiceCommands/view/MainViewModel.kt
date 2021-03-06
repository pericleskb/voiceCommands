package com.donkeymonkey.voiceCommands.view

import android.content.Context
import androidx.lifecycle.*
import com.donkeymonkey.voiceCommands.R
import com.donkeymonkey.voiceCommands.delegates.PlaySoundDelegate
import com.donkeymonkey.voiceCommands.delegates.PlaySoundDelegateImpl
import com.donkeymonkey.voicecommandsdata.entities.Command
import com.donkeymonkey.voicecommandsdata.repositories.CommandRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(context: Context?,
                    private val commandsRepository: CommandRepositoryImpl): ViewModel() {
    private val buttons: LiveData<List<Command>> = commandsRepository.getCommands()
    private val playSoundDelegate: PlaySoundDelegate = PlaySoundDelegateImpl(context)

    fun getButtons(): LiveData<List<Command>> {
        return buttons
    }

    fun playSound(rawFileId: Int) {
        playSoundDelegate.playSound(rawFileId)
    }
}

class MainViewModelFactory(private val context: Context?,
                           private val commandsRepository: CommandRepositoryImpl)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(context, commandsRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}