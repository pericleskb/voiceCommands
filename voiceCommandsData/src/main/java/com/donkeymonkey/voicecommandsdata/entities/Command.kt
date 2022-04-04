package com.donkeymonkey.voicecommandsdata.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Command(
    @PrimaryKey
    val name: String,
    val color: String, //can this be HEX?
    val voiceCommand: String, //URI
    val image: String,
    val positions: Int
)
