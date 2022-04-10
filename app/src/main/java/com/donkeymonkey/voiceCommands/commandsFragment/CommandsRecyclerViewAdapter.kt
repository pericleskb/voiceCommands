package com.donkeymonkey.voiceCommands.commandsFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.donkeymonkey.voiceCommands.R
import com.donkeymonkey.voiceCommands.databinding.LayoutAddCommandButtonBinding
import com.donkeymonkey.voiceCommands.databinding.LayoutCommandSquareBinding
import com.donkeymonkey.voicecommandsdata.entities.Command

class CommandsRecyclerViewAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val commandsList: ArrayList<Command> = ArrayList()

    private val addButtonType = 0;
    private val commandType = 1;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == addButtonType) {
            return AddButtonViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.layout_add_command_button, parent, false),
                parent
            )
        }
        return CommandViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_command_square, parent, false),
            parent
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
            addButtonType
        } else {
            commandType
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

    class CommandViewHolder(view: View, private val parent: ViewGroup): RecyclerView.ViewHolder(view) {
        private val binding = LayoutCommandSquareBinding.bind(view)

        fun bind(command: Command) {
            val tileWidth = parent.measuredWidth / 4
            binding.textView.text = command.name
            val layoutParams = FrameLayout.LayoutParams(tileWidth, tileWidth)
            layoutParams.setMargins(tileWidth/8, tileWidth/8, tileWidth/8, tileWidth/8)
            binding.root.layoutParams = layoutParams
        }
    }

    class AddButtonViewHolder(view: View, private val parent: ViewGroup): RecyclerView.ViewHolder(view) {
        private val binding = LayoutAddCommandButtonBinding.bind(view)

        fun bind() {
            val width = parent.measuredWidth / 3
            binding.root.text = "+"
            binding.root.width = width
        }
    }
}