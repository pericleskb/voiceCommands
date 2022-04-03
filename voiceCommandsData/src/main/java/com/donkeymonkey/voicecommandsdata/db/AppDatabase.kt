package com.donkeymonkey.voicecommandsdata.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.donkeymonkey.voicecommandsdomain.entities.Command

@Database(entities = [Command::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract class commandDao(): CommandDao
}