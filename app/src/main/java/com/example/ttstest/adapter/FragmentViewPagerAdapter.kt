package com.example.ttstest.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class FragmentViewPagerAdapter @AssistedInject constructor(
    @Assisted private val size: Int,
    @Assisted private val block: (Int) -> Fragment,
    @Assisted private val activity: FragmentActivity
) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = size

    override fun createFragment(position: Int): Fragment {
        return block(position)
    }
}


@AssistedFactory
interface FragmentViewPagerAdapterFactory {
    fun create(
        activity: FragmentActivity,
        size: Int,
        block: (Int) -> Fragment
    ): FragmentViewPagerAdapter {
        return FragmentViewPagerAdapter(size = size, block = block, activity = activity)
    }
}