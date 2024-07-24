package com.nodosacademy.boldforecast.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nodosacademy.boldforecast.network.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    var homeScreenUIState by mutableStateOf(HomeScreenUIState())
        private set

    private var locationSearchJob: Job? = null
    private val searchDelay = 300L

    fun onScreenEvent(homeScreenEvent: HomeScreenEvent) {
        when (homeScreenEvent) {
            is HomeScreenEvent.OnItemNavigation -> TODO()
            is HomeScreenEvent.OnSearchElement -> {
                homeScreenUIState = homeScreenUIState.copy(
                    searchText = homeScreenEvent.elementText
                )
                if (homeScreenEvent.elementText.isNotBlank()) {
                    doSearch(homeScreenEvent.elementText)
                }
            }
        }
    }

    private fun doSearch(textToSearch: String) {
        locationSearchJob?.cancel()
        locationSearchJob = viewModelScope.launch {
            delay(searchDelay)
            homeScreenUIState = homeScreenUIState.copy(
                state = State.Searching
            )
            val locationList = repository.searchLocation(textToSearch)
            Log.e("response", locationList.toString())
            homeScreenUIState = homeScreenUIState.copy(
                state = State.WithItems(locationList)
            )
        }
    }

}