package com.donkeymonkey.voicecommandsdata.repositories

import androidx.lifecycle.LiveData
import com.donkeymonkey.voicecommandsdata.dataSources.local.LocalDataSource
import com.donkeymonkey.voicecommandsdata.entities.Command

class CommandRepositoryImpl(private val localDataSource: LocalDataSource): CommandRepository {
    override suspend fun getCommands(): LiveData<List<Command>> {
        return localDataSource.getCommands()
    }
}