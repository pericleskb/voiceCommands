package com.donkeymonkey.voiceCommands.view.commandsFragment

interface CommandPressedListener {
    fun addNewCommand()
    fun playSound(rawFileId: Int)
}