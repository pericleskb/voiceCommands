package com.donkeymonkey.voicecommandsdata.hardcodedCommands

import com.donkeymonkey.voicecommandsdata.entities.Command

interface CommandGenerator {
    fun generateCommands(): ArrayList<Command>
}