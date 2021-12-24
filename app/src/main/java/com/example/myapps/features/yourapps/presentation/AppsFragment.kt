package com.example.myapps.features.yourapps.presentation

import android.content.pm.PackageInfo
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myapps.R
import com.example.myapps.databinding.FragmentAppsBinding
import com.example.myapps.features.yourapps.presentation.adapter.AppsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppsFragment : Fragment(R.layout.fragment_apps) {

    private val viewBinding: FragmentAppsBinding by viewBinding(FragmentAppsBinding::bind)
    private val viewModel: AppsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        val appList: MutableList<PackageInfo> =
            requireContext().packageManager.getInstalledPackages(0)
        val appsRecyclerView = viewBinding.rvApps
        appsRecyclerView.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        appsRecyclerView.adapter = AppsAdapter(appList, requireContext())
    }
}
