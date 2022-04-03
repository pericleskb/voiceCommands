package com.donkeymonkey.voicecommandsdata.dataSources.local

import androidx.lifecycle.LiveData
import com.donkeymonkey.voicecommandsdata.entities.Command

interface LocalDataSource {
    suspend fun getCommands(): LiveData<List<Command>>
}