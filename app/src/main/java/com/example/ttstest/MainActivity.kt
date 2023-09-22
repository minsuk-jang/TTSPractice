package com.example.ttstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.size
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.ttstest.adapter.FragmentViewPagerAdapterFactory
import com.example.ttstest.base.BaseActivity
import com.example.ttstest.databinding.ActivityMainBinding
import com.example.ttstest.manager.TTSManager
import com.example.ttstest.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val vm: MainActivityViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MainActivityViewModel(
                    ttsManager = TTSManager(context = this@MainActivity)
                ) as T
            }

            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                return MainActivityViewModel(
                    ttsManager = TTSManager(context = this@MainActivity)
                ) as T
            }
        }
    }

    @Inject
    lateinit var fragmentViewPagerAdapter: FragmentViewPagerAdapterFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewPager()
        vm.start(text = "Activity")
    }

    private fun initViewPager() {
        with(binding.viewPager2) {
            adapter = fragmentViewPagerAdapter.create(activity = this@MainActivity, size = 10) {
                MainFragment.newInstance(
                    position = it
                )
            }
            offscreenPageLimit = 1
        }
    }
}