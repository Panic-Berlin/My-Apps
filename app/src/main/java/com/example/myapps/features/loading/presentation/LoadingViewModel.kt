package com.example.myapps.features.loading.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapps.utils.SingleLiveEvent
import com.example.myapps.utils.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoadingViewModel @Inject constructor(): ViewModel() {

    private val _isLoading = MutableLiveData(false)
    val isLoading get() = _isLoading.asLiveData()

    val goToStartFragment = SingleLiveEvent<Unit>()

    fun startLoading(){
        _isLoading.value = true
        viewModelScope.launch {
            loading()
        }
    }

    private suspend fun loading(){
        delay(LOADING_DELAY)
        goToStartFragment.call()
        _isLoading.value = false
    }
}

private const val LOADING_DELAY = 5000L
