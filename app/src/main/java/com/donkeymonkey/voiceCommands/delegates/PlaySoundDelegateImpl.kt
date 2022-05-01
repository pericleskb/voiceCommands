package com.donkeymonkey.voiceCommands.delegates

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer

class PlaySoundDelegateImpl(private val context: Context?): PlaySoundDelegate {

    private var mediaPlayer: MediaPlayer? = null

    override fun playSound(rawSoundId: Int) {
        context?.applicationContext?.let { context ->
            mediaPlayer = MediaPlayer.create(context, rawSoundId).apply {
                setAudioAttributes(
                    AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
                )
                setOnCompletionListener {
                    it.reset()
                    it.release()
                    mediaPlayer = null
                }
                start()
            }
        }
    }
}