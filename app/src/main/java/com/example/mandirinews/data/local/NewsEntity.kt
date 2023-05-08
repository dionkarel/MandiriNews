package com.example.mandirinews.data.local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsEntity(
    var author: String?,
    var title: String?,
    var description: String?,
    var url: String?,
    var urlToImage: String?,
    var publishedAt: String?,
    var content: String?
) : Parcelable

