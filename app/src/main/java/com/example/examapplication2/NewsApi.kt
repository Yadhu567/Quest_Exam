package com.example.examapplication2

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface NewsApi {
    @GET("news")
    suspend fun getNewsDetail(
        @Query("access_key") apiKey: String = Constants.API_KEY,
        @Query("source") source: String,
        @Query("country") country: String,
    ): NewsEntity
}