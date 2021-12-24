package com.example.myapps.features.start.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myapps.R
import com.example.myapps.databinding.FragmentStartBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartFragment: Fragment(R.layout.fragment_start) {

    private val viewBinding: FragmentStartBinding by viewBinding(FragmentStartBinding::bind)
    private val viewModel: StartViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        initViews()
    }

    private fun initViews() {
        viewBinding.btnStart.setOnClickListener {
            viewModel.onStartClick()
        }
    }

    private fun observe() {
        viewModel.goToAppsFragment.observe(viewLifecycleOwner){
            val navigate = StartFragmentDirections.actionStartFragmentToAppsFragment()
            findNavController().navigate(navigate)
        }
    }
}
