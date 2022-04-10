package com.donkeymonkey.voicecommandsdata.repositories

import androidx.lifecycle.LiveData
import com.donkeymonkey.voicecommandsdata.db.CommandDao
import com.donkeymonkey.voicecommandsdata.entities.Command

class CommandRepositoryImpl(private val commandDao: CommandDao): CommandRepository {
    override fun getCommands(): LiveData<List<Command>> {
        return commandDao.getAll()
    }

    override suspend fun addCommand(command: Command) {
        commandDao.insert(command)
    }

    override suspend fun deleteCommand(command: Command) {
        commandDao.delete(command)
    }
}