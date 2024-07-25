package com.nodosacademy.boldforecast.network

import com.nodosacademy.boldforecast.data.ForecastResponse
import com.nodosacademy.boldforecast.data.SearchResponse
import com.nodosacademy.boldforecast.detail.data.DetailScreenData
import com.nodosacademy.boldforecast.home.LocationItem

interface NetworkDataSource {

    suspend fun searchLocation(text: String): List<LocationItem>

    suspend fun getForecast(lat: String, lon:String): DetailScreenData
}