package com.donkeymonkey.voiceCommands.view.commandsFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.donkeymonkey.voiceCommands.R
import com.donkeymonkey.voiceCommands.databinding.LayoutCommandSquareBinding
import com.donkeymonkey.voicecommandsdata.entities.Command

class CommandsRecyclerViewAdapter(private val commandPressedListener: CommandPressedListener): RecyclerView.Adapter<CommandsRecyclerViewAdapter.CommandViewHolder>() {

    private val commandsList: ArrayList<Command> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommandViewHolder {
        return CommandViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_command_square, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CommandViewHolder, position: Int) {
        holder.bind(commandsList[position], commandPressedListener)
    }

    override fun getItemCount(): Int {
        return commandsList.size
    }

    fun setButtons(commands: List<Command>) {
        commandsList.clear()
        commandsList.addAll(commands)
        notifyDataSetChanged()
    }

    class CommandViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = LayoutCommandSquareBinding.bind(view)

        fun bind(command: Command, commandPressedListener: CommandPressedListener) {
            binding.imageView.setImageDrawable(ResourcesCompat.getDrawable(itemView.resources, command.image, null))
            binding.root.setOnClickListener { commandPressedListener.playSound(command.voiceCommand) }
        }
    }
}