package com.example.ttstest.manager

import android.content.Context
import android.speech.tts.TextToSpeech
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TTSManager @Inject constructor(
    @ActivityContext private val context: Context
) {
    private val module: TextToSpeech = TextToSpeech(context) {
        if (it != TextToSpeech.ERROR) { }
    }

}