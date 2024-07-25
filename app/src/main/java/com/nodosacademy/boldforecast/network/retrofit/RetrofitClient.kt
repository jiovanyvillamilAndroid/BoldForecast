package com.nodosacademy.boldforecast.network.retrofit

import com.nodosacademy.boldforecast.detail.data.DateDataUI
import com.nodosacademy.boldforecast.detail.data.DetailScreenData
import com.nodosacademy.boldforecast.detail.data.HourDataUI
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

    override suspend fun getForecast(lat: String, lon: String): DetailScreenData {
        val forecast = apiService.getForecast("$lat,$lon")
        val hourData = arrayListOf<HourDataUI>()
        val datesData = arrayListOf<DateDataUI>()

        forecast.forecast?.forecastday?.first()?.hour?.forEachIndexed { index, hour ->
            hourData.add(
                HourDataUI(
                    time = "${index + 1}",
                    tempC = hour.tempC ?: 0.0,
                    conditionIconURL = hour.condition?.icon.orEmpty()
                )
            )
        }

        forecast.forecast?.forecastday?.forEach {
            DateDataUI(
                dayName = "martes",
                conditionIcon = it.day?.condition?.icon.orEmpty(),
                maxTemp = it.day?.maxtempC ?: 0.0,
                minTemp = it.day?.mintempC ?: 0.0

            )
        }

        return DetailScreenData(
            cityName = forecast.location?.name.orEmpty(),
            currentTemp = forecast.current?.tempC ?: 0.0,
            hoursForecast = hourData,
            datesData = datesData
        )
    }


}