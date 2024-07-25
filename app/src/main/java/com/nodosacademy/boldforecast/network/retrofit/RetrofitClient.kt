package com.nodosacademy.boldforecast.network.retrofit

import android.annotation.SuppressLint
import com.nodosacademy.boldforecast.data.Forecastday
import com.nodosacademy.boldforecast.detail.data.DayDataUI
import com.nodosacademy.boldforecast.detail.data.DetailScreenUIState
import com.nodosacademy.boldforecast.detail.data.HourDataUI
import com.nodosacademy.boldforecast.home.LocationItem
import com.nodosacademy.boldforecast.network.NetworkDataSource
import java.text.SimpleDateFormat
import java.util.Date
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

    override suspend fun getForecast(lat: Double, lon: Double): DetailScreenUIState {
        val forecast = apiService.getForecast("$lat,$lon")

        val forecastList = forecast.forecast?.forecastday
        val currentForecastDay = forecastList?.first()

        return DetailScreenUIState(
            cityName = forecast.location?.name.orEmpty(),
            country = forecast.location?.country.orEmpty(),
            currentConditionIconURL = "https:" + forecast.current?.condition?.icon.orEmpty(),
            maxTemp = currentForecastDay?.day?.maxtempC ?: 0.0,
            minTemp = currentForecastDay?.day?.mintempC ?: 0.0,
            currentTemp = forecast.current?.tempC ?: 0.0,
            hoursForecast = currentForecastDay?.let { getForecastHourList(it) } ?: arrayListOf(),
            daysForecastDataList = getForecastDaysList(forecastList)
        )
    }

    private fun getForecastDaysList(forecastList: ArrayList<Forecastday>?): List<DayDataUI> {
        val datesData = arrayListOf<DayDataUI>()
        forecastList?.forEach {
            it.day?.let { day ->
                datesData.add(
                    DayDataUI(
                        dayName = getDayName(it.date.orEmpty()),
                        conditionIcon = "https:" + day.condition?.icon.orEmpty(),
                        maxTemp = day.maxtempC ?: 0.0,
                        minTemp = day.mintempC ?: 0.0

                    )
                )
            }
        }
        return datesData
    }

    private fun getForecastHourList(forecastDay: Forecastday): List<HourDataUI> {
        val hourData = arrayListOf<HourDataUI>()
        forecastDay.hour.forEachIndexed { index, hour ->
            val hourText = if (index < 10) {
                "0${index}"
            } else {
                "$index"
            }

            hourData.add(
                HourDataUI(
                    time = hourText,
                    tempC = hour.tempC ?: 0.0,
                    conditionIconURL = "https:" + hour.condition?.icon.orEmpty()
                )
            )
        }
        return hourData
    }

    @SuppressLint("SimpleDateFormat")
    private fun getDayName(textDate: String): String {
        val inFormat = SimpleDateFormat("yyyy-MM-dd")
        val date: Date? = inFormat.parse(textDate)
        val outFormat = SimpleDateFormat("EEEE")
        return date?.let { outFormat.format(it) }.orEmpty()
    }


}