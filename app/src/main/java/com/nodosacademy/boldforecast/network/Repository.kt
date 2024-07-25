package com.nodosacademy.boldforecast.network

import com.nodosacademy.boldforecast.home.LocationItem
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(private val networkDataSource: NetworkDataSource) {

    suspend fun searchLocation(text: String): List<LocationItem> {
        return networkDataSource.searchLocation(text)
    }

    suspend fun getForecast(lat: String, lon: String) = networkDataSource.getForecast(lat, lon)
}