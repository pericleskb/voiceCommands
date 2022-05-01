package com.donkeymonkey.voicecommandsdata.repositories

import com.donkeymonkey.voicecommandsdata.entities.Command
import com.donkeymonkey.voicecommandsdata.hardcodedCommands.CommandGenerator

class CommandRepositoryImpl(private val commandGenerator: CommandGenerator): CommandRepository {
    override fun getCommands(): List<Command> {
        return commandGenerator.generateCommands()
    }
}