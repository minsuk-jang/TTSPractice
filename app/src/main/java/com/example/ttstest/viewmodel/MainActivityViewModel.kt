package com.example.ttstest.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ttstest.manager.TTSManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class MainActivityViewModel (
    private val ttsManager: TTSManager
) : ViewModel() {

    fun start(text : String){
        ttsManager.start(text = text)
    }

    fun stop(){
        ttsManager.stop()
    }


    override fun onCleared() {
        super.onCleared()
        ttsManager.release()
    }
}