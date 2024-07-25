package com.nodosacademy.boldforecast.detail.data

data class DetailScreenData(
    val cityName: String,
    val currentTemp: Double,
    val hoursForecast: List<HourDataUI>,
    val datesData: List<DateDataUI>
)