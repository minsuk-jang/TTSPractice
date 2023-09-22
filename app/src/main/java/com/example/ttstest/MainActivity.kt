package com.example.ttstest

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ttstest.base.BaseActivity
import com.example.ttstest.databinding.ActivityMainBinding
import com.example.ttstest.manager.TTSManager
import com.example.ttstest.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val vm: MainActivityViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MainActivityViewModel(
                    ttsManager = TTSManager(context = this@MainActivity)
                ) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm.start(text = "Text to speach is working Text to speach is working Text to speach is working Text to speach is working Text to speach is working Text to speach is working Text to speach is working ")
    }
}