package com.nodosacademy.boldforecast.detail.data

data class DetailScreenUIState(
    val cityName: String = "",
    val country: String = "",
    val currentTemp: Double = 0.0,
    val maxTemp: Double = 0.0,
    val minTemp: Double = 0.0,
    val currentConditionIconURL: String = "",
    val hoursForecast: List<HourDataUI> = emptyList(),
    val daysForecastDataList: List<DayDataUI> = emptyList(),
)