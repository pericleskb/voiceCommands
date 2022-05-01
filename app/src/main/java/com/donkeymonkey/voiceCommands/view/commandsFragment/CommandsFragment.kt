package com.donkeymonkey.voiceCommands.view.commandsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.donkeymonkey.voiceCommands.view.MainViewModel
import com.donkeymonkey.voiceCommands.view.MainViewModelFactory
import com.donkeymonkey.voiceCommands.databinding.FragmentCommandsBinding
import com.donkeymonkey.voicecommandsdata.db.VoiceCommandsDatabase
import com.donkeymonkey.voicecommandsdata.repositories.CommandRepositoryImpl

class CommandsFragment: Fragment(), CommandPressedListener {

    private var _binding: FragmentCommandsBinding? = null
    private val binding get() = _binding!!

    private val mainViewModel: MainViewModel by activityViewModels {
        MainViewModelFactory(
            CommandRepositoryImpl(VoiceCommandsDatabase.getDatabase(requireActivity().baseContext).commandDao())
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCommandsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CommandsRecyclerViewAdapter(this)
        binding.commandsRecyclerView.layoutManager = GridLayoutManager(context, 3)
        binding.commandsRecyclerView.adapter = adapter
        mainViewModel.getButtons().observe(viewLifecycleOwner) { list ->
            adapter.setButtons(list)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun addNewCommand() {
        mainViewModel.addCommand()
    }

    override fun playSound() {
        TODO("Not yet implemented")
    }
}