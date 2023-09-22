package com.example.ttstest.manager

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import com.example.ttstest.TAG
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject
import javax.inject.Singleton

@ActivityRetainedScoped
class TTSManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val module: TextToSpeech = TextToSpeech(context) {
        if (it != TextToSpeech.ERROR) {
            Log.e(TAG, "Successs")
        }
    }

    fun start() {
        module.speak("Test1", TextToSpeech.QUEUE_FLUSH, null, null)
    }

    fun stop() {
        module.stop()
    }

}