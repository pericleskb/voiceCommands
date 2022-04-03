package com.donkeymonkey.voicecommandsdata.repositories

import androidx.lifecycle.LiveData
import com.donkeymonkey.voicecommandsdata.entities.Command

interface CommandRepository {
    suspend fun getCommands(): LiveData<List<Command>>
}