package com.donkeymonkey.voiceCommands.commandsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.donkeymonkey.voiceCommands.MainViewModel
import com.donkeymonkey.voiceCommands.MainViewModelFactory
import com.donkeymonkey.voiceCommands.databinding.FragmentCommandsBinding
import com.donkeymonkey.voicecommandsdata.db.VoiceCommandsDatabase
import com.donkeymonkey.voicecommandsdata.repositories.CommandRepositoryImpl

class CommandsFragment: Fragment() {

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
        val adapter = CommandsRecyclerViewAdapter()
        mainViewModel.getButtons().observe(viewLifecycleOwner) { list ->
            adapter.setButtons(list)
        }
        binding.commandsRecyclerView.adapter = adapter
        binding.commandsRecyclerView.layoutManager = GridLayoutManager(context, 3)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}