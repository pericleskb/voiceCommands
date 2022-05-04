package com.donkeymonkey.voiceCommands.hardcodedCommands

import com.donkeymonkey.voiceCommands.R
import com.donkeymonkey.voicecommandsdata.entities.Command
import com.donkeymonkey.voicecommandsdata.hardcodedCommands.CommandGenerator

class CommandGeneratorImpl: CommandGenerator {

    private val commandsList: ArrayList<Command> = arrayListOf(
        Command("look", R.raw.look ,R.mipmap.look),
        Command("eimai", R.raw.eimai ,R.mipmap.eimai),
        Command("my_name_is", R.raw.my_name_is ,R.mipmap.my_name_is),
        Command("dont_know", R.raw.dont_know ,R.mipmap.dont_know),
        Command("like", R.raw.like ,R.mipmap.like),
        Command("want", R.raw.want ,R.mipmap.want),
        Command("dont_want", R.raw.dont_want ,R.mipmap.dont_want),
        Command("water", R.raw.water ,R.mipmap.water),
        Command("toilet", R.raw.toilet ,R.mipmap.toilet),
        Command("to_eat", R.raw.to_eat ,R.mipmap.to_eat),
        Command("to_see", R.raw.to_see ,R.mipmap.to_see),
        Command("to_listen", R.raw.to_listen ,R.mipmap.to_listen),
        Command("to_sleep", R.raw.to_sleep ,R.mipmap.to_sleep),
        Command("volta", R.raw.volta ,R.mipmap.volta),
        Command("tv", R.raw.tv ,R.mipmap.tv),
        Command("makaronia", R.raw.makaronia ,R.mipmap.makaronia),
        Command("bed", R.raw.bed ,R.mipmap.bed),
        Command("park", R.raw.park ,R.mipmap.park),
        Command("beach", R.raw.beach ,R.mipmap.beach),
        Command("juice", R.raw.juice ,R.mipmap.juice),
        Command("sweets", R.raw.sweets ,R.mipmap.sweets),
        Command("coffee", R.raw.coffee ,R.mipmap.coffee),
        Command("music", R.raw.music ,R.mipmap.music),
        Command("plate", R.raw.plate ,R.mipmap.plate),
        Command("to_cook", R.raw.to_cook ,R.mipmap.to_cook),
        Command("to_wash", R.raw.to_wash ,R.mipmap.to_wash),
        Command("to_iron", R.raw.to_iron ,R.mipmap.to_iron)
    )

    override fun generateCommands(): ArrayList<Command> {
        return commandsList
    }
}