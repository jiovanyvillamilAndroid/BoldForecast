package com.nodosacademy.boldforecast.network.retrofit

import com.nodosacademy.boldforecast.data.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search.json")
    suspend fun searchLocation(@Query("q") inputText: String): List<SearchResponse>

}