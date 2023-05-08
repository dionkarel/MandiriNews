package com.example.mandirinews.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsResponse(
    @SerializedName("author")
    var author: String?,

    @SerializedName("title")
    var title: String?,

    @SerializedName("description")
    var description: String?,

    @SerializedName("url")
    var url: String?,

    @SerializedName("urlToImage")
    var urlToImage: String?,

    @SerializedName("publishedAt")
    var publishedAt: String?,

    @SerializedName("content")
    var content: String?
) : Parcelable
