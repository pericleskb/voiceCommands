package com.donkeymonkey.voiceCommands.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.donkeymonkey.voiceCommands.databinding.ActivityMainBinding
import com.donkeymonkey.voicecommandsdata.db.VoiceCommandsDatabase
import com.donkeymonkey.voicecommandsdata.repositories.CommandRepositoryImpl

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels {
            MainViewModelFactory(
                baseContext,
                CommandRepositoryImpl(VoiceCommandsDatabase.getDatabase(baseContext).commandDao())
            )
        }
        val binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)
    }
}