package com.example.ttstest.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ttstest.manager.TTSManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val ttsManager: TTSManager
) : ViewModel() {

    fun start(){
        ttsManager.start()
    }

    fun stop(){
        ttsManager.stop()
    }
}