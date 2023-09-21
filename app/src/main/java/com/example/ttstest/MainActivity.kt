package com.example.ttstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.size
import com.example.ttstest.adapter.FragmentViewPagerAdapterFactory
import com.example.ttstest.base.BaseActivity
import com.example.ttstest.databinding.ActivityMainBinding
import com.example.ttstest.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val vm : MainActivityViewModel by activityViewmodel

    @Inject
    lateinit var fragmentViewPagerAdapter: FragmentViewPagerAdapterFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewPager()
    }

    private fun initViewPager() {
        with(binding.viewPager2) {
            adapter = fragmentViewPagerAdapter.create(activity = this@MainActivity, size = 3) {
                MainFragment.newInstance()
            }

        }
    }
}