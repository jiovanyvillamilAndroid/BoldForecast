package com.nodosacademy.boldforecast.data

import com.google.gson.annotations.SerializedName


data class Forecast(

    @SerializedName("forecastday") var forecastday: ArrayList<Forecastday> = arrayListOf()

)