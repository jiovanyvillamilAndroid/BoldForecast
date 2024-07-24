package com.nodosacademy.boldforecast.network.retrofit

import com.nodosacademy.boldforecast.home.LocationItem
import com.nodosacademy.boldforecast.network.NetworkDataSource
import javax.inject.Inject

class RetrofitClient @Inject constructor(private val apiService: ApiService) : NetworkDataSource {

    override suspend fun searchLocation(text: String): List<LocationItem> {

        return apiService.searchLocation(text).map { searchResponse ->
            with(searchResponse) {
                LocationItem(
                    name = name,
                    country = country,
                    lat = lat,
                    lon = lon
                )
            }
        }
    }


}