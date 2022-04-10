package com.donkeymonkey.voicecommandsdata.repositories

import androidx.lifecycle.LiveData
import com.donkeymonkey.voicecommandsdata.entities.Command

interface CommandRepository {
    fun getCommands(): LiveData<List<Command>>
    suspend fun addCommand(command: Command)
    suspend fun deleteCommand(command: Command)
}