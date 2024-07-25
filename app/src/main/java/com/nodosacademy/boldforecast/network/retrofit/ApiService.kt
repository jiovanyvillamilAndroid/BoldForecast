package com.nodosacademy.boldforecast.network.retrofit

import com.nodosacademy.boldforecast.data.ForecastResponse
import com.nodosacademy.boldforecast.data.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search.json")
    suspend fun searchLocation(@Query("q") inputText: String): List<SearchResponse>

    @GET("forecast.json")
    suspend fun getForecast(
        @Query("q") queryParam: String,
        @Query("days") days: Int = 4
    ): ForecastResponse

}