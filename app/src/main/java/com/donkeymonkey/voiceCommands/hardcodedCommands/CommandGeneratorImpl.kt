package com.donkeymonkey.voiceCommands.hardcodedCommands

import com.donkeymonkey.voiceCommands.R
import com.donkeymonkey.voicecommandsdata.entities.Command
import com.donkeymonkey.voicecommandsdata.hardcodedCommands.CommandGenerator

class CommandGeneratorImpl: CommandGenerator {

    private val commandsList: ArrayList<Command> = arrayListOf(
        Command("look", "123", R.raw.look ,R.mipmap.look, 0),
        Command("volta", "123", R.raw.volta ,R.mipmap.volta, 2),
        Command("eimai", "123", R.raw.eimai ,R.mipmap.eimai, 1))

    override fun generateCommands(): ArrayList<Command> {
        return commandsList
    }
}