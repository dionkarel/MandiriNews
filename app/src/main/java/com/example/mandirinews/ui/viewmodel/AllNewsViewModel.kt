package com.example.mandirinews.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mandirinews.data.Repository
import com.example.mandirinews.data.local.NewsEntity

class AllNewsViewModel(private val repository: Repository) : ViewModel() {
    fun getAllNews(): LiveData<List<NewsEntity>> = repository.getAllNews()
}