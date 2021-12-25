package com.example.myapps.features.loading.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myapps.R
import com.example.myapps.databinding.FragmentLoadingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoadingFragment: Fragment(R.layout.fragment_loading) {

    private val viewBinding: FragmentLoadingBinding by viewBinding(FragmentLoadingBinding::bind)
    private val viewModel: LoadingViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
    }


    private fun observe() {
        viewModel.isLoading.observe(viewLifecycleOwner){
            viewBinding.cpiLoading.isVisible = it
        }
        viewModel.goToStartFragment.observe(viewLifecycleOwner){
            val navigate = LoadingFragmentDirections.actionLoadingFragmentToStartFragment()
            findNavController().navigate(navigate)
        }
    }
}
