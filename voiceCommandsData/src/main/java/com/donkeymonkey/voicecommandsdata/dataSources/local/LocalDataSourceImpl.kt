package com.donkeymonkey.voicecommandsdata.dataSources.local

import androidx.lifecycle.LiveData
import com.donkeymonkey.voicecommandsdata.db.CommandDao
import com.donkeymonkey.voicecommandsdata.entities.Command

class LocalDataSourceImpl(private val commandDao: CommandDao): LocalDataSource {
    override suspend fun getCommands(): LiveData<List<Command>> {
        return commandDao.getAll()
    }
}