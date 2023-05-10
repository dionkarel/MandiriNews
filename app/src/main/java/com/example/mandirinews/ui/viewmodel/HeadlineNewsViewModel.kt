package com.example.mandirinews.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mandirinews.data.Repository
import com.example.mandirinews.data.local.NewsEntity

class HeadlineNewsViewModel(private val repository: Repository) : ViewModel() {
    fun getHeadlineNews(): LiveData<List<NewsEntity>> = repository.getHeadlineNews()
}