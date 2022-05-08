package com.donkeymonkey.voiceCommands.view.addCommandsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.donkeymonkey.voiceCommands.databinding.FragmentNewCommandLayoutBinding
import com.donkeymonkey.voiceCommands.view.MainViewModel

//ToDo use different view model
class NewCommandFragment: Fragment() {
    private var _binding: FragmentNewCommandLayoutBinding? = null
    private val binding get() = _binding!!

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewCommandLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }
}