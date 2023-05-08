package com.example.mandirinews.network

import com.example.mandirinews.BuildConfig
import com.example.mandirinews.data.response.ResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    fun getHeadlines(
        @Query("country") country: String?,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): Call<ResponseItem>

    @GET("everything")
    fun getAllNews(
        @Query("q") q: String?,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): Call<ResponseItem>
}