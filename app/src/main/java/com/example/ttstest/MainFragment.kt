package com.example.ttstest

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import com.example.ttstest.base.BaseFragment
import com.example.ttstest.databinding.FragmentMainBinding
import com.example.ttstest.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val vm: MainActivityViewModel by activityViewModels()

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment().apply {
                arguments = bundleOf()
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}