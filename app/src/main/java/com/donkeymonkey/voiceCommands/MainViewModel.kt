package com.donkeymonkey.voiceCommands

import androidx.lifecycle.*
import com.donkeymonkey.voiceCommands.extensions.notifyObserver
import com.donkeymonkey.voicecommandsdata.entities.Command
import com.donkeymonkey.voicecommandsdata.repositories.CommandRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val commandsRepository: CommandRepositoryImpl): ViewModel() {
    private val buttons: LiveData<List<Command>> = commandsRepository.getCommands()

    fun getButtons(): LiveData<List<Command>> {
        return buttons
    }

    fun addCommand() {
        viewModelScope.launch(Dispatchers.IO) {
            commandsRepository.addCommand(Command("aaabb", "FFAAFF", "test", "some uri", 1))
        }
    }
}

class MainViewModelFactory(private val commandsRepository: CommandRepositoryImpl): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(commandsRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}