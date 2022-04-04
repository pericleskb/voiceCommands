package com.donkeymonkey.voiceCommands.commandsFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.donkeymonkey.voiceCommands.R
import com.donkeymonkey.voiceCommands.databinding.LayoutAddCommandButtonBinding
import com.donkeymonkey.voiceCommands.databinding.LayoutCommandSquareBinding
import com.donkeymonkey.voicecommandsdata.entities.Command

class CommandsRecyclerViewAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val commandsList: ArrayList<Command> = ArrayList()

    private val ADD_BUTTON_TYPE = 0;
    private val COMMAND_TYPE = 1;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommandViewHolder {
        if (viewType == ADD_BUTTON_TYPE) {
            return
        }
        return CommandViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_command_square, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is AddButtonViewHolder -> {
                holder.bind()
            }
            is CommandViewHolder -> {
                holder.bind(commandsList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return commandsList.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (commandsList.isEmpty() || position == commandsList.size) {
            ADD_BUTTON_TYPE
        } else {
            COMMAND_TYPE
        }
    }

    fun setButtons(commands: List<Command>) {
        commandsList.clear()
        commandsList.addAll(commands)
        notifyDataSetChanged()
    }

    fun addButton(command: Command) {
        commandsList.add(command)
        notifyItemChanged(commandsList.size -1)
    }

    class CommandViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = LayoutCommandSquareBinding.bind(view)

        fun bind(command: Command) {
            binding.root.text = command.name
        }
    }

    class AddButtonViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = LayoutAddCommandButtonBinding.bind(view)

        fun bind() {
            binding.root.text = "+"
        }
    }
}