package com.donkeymonkey.voicecommandsdata.repositories

import com.donkeymonkey.voicecommandsdata.entities.Command

interface CommandRepository {
    fun getCommands(): List<Command>
//    suspend fun addCommand(command: Command)
//    suspend fun deleteCommand(command: Command)
}