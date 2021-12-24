package com.example.myapps.features.start.presentation

import androidx.lifecycle.ViewModel
import com.example.myapps.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(): ViewModel() {

    val goToAppsFragment = SingleLiveEvent<Unit>()

    fun onStartClick(){
        goToAppsFragment.call()
    }
}
