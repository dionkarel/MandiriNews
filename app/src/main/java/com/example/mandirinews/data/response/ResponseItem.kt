package com.example.mandirinews.data.response

import com.google.gson.annotations.SerializedName

data class ResponseItem(
    @SerializedName("status") val status: String,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("articles") val articles: List<NewsResponse>
)
