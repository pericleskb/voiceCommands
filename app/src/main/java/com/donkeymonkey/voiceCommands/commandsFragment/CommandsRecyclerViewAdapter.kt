package com.donkeymonkey.voiceCommands.commandsFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.donkeymonkey.voiceCommands.R
import com.donkeymonkey.voiceCommands.databinding.LayoutCommandSquareBinding

class CommandsRecyclerViewAdapter(): RecyclerView.Adapter<CommandsRecyclerViewAdapter.CommandViewHolder>() {

    private val commandsList: ArrayList<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommandViewHolder {
        return CommandViewHolder(
            LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_command_square, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CommandViewHolder, position: Int) {
        holder.bind(commandsList[position])
    }

    override fun getItemCount(): Int {
        return commandsList.size
    }

    fun setButtons(texts: ArrayList<String>) {
        commandsList.clear()
        commandsList.addAll(texts)
        notifyDataSetChanged()
    }

    fun addButton(text: String) {
        commandsList.add(text)
        notifyItemChanged(commandsList.size -1)
    }

    class CommandViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = LayoutCommandSquareBinding.bind(view)

        fun bind(text: String) {
            binding.root.text = text
        }
    }
}