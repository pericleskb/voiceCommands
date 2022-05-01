package com.donkeymonkey.voicecommandsdata.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Command(
    @PrimaryKey
    val name: String,
    val voiceCommand: Int, //URI
    val image: Int
)
