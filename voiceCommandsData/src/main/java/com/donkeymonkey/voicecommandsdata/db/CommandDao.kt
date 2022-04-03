package com.donkeymonkey.voicecommandsdata.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.donkeymonkey.voicecommandsdomain.entities.Command

@Dao
interface CommandDao {
    @Query("SELECT * FROM command")
    fun getAll(): LiveData<List<Command>>

    @Insert
    fun insert(command: Command)

    @Delete
    fun delete(command: Command)
}