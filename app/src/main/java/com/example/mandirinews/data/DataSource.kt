package com.example.mandirinews.data

import androidx.lifecycle.LiveData
import com.example.mandirinews.data.local.NewsEntity

interface DataSource {
    fun getHeadlineNews(): LiveData<List<NewsEntity>>
    fun getAllNews(): LiveData<List<NewsEntity>>
}