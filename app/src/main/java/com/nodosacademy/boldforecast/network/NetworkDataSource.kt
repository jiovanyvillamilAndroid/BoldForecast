package com.nodosacademy.boldforecast.network

import com.nodosacademy.boldforecast.detail.data.DetailScreenUIState
import com.nodosacademy.boldforecast.home.LocationItem

interface NetworkDataSource {

    suspend fun searchLocation(text: String): List<LocationItem>

    suspend fun getForecast(lat: Double, lon:Double): DetailScreenUIState
}