package com.nodosacademy.boldforecast.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nodosacademy.boldforecast.detail.data.DetailScreenUIState
import com.nodosacademy.boldforecast.network.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    var screenUIState by mutableStateOf(DetailScreenUIState())

    fun fetchLocationDetails(lat: String?, lon: String?) {
        viewModelScope.launch {
            screenUIState = repository.getForecast(lat?.toDouble() ?: 0.0, lon?.toDouble() ?: 0.0)
        }
    }
}