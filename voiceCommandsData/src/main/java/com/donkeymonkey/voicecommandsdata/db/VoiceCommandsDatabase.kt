package com.donkeymonkey.voicecommandsdata.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.donkeymonkey.voicecommandsdata.entities.Command

@Database(entities = [Command::class], version = 1)
abstract class VoiceCommandsDatabase: RoomDatabase() {
    abstract fun commandDao(): CommandDao

    companion object {
        @Volatile
        private var INSTANCE: VoiceCommandsDatabase? = null

        fun getDatabase(context: Context): VoiceCommandsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context, VoiceCommandsDatabase::class.java,
                    VoiceCommandsDatabase::class.simpleName!!
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}