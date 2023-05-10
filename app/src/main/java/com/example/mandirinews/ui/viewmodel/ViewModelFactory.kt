package com.example.mandirinews.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mandirinews.data.Repository
import com.example.mandirinews.di.Injection

class ViewModelFactory private constructor(private val dataRepository: Repository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository()).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HeadlineNewsViewModel::class.java) -> {
                HeadlineNewsViewModel(dataRepository) as T
            }
            modelClass.isAssignableFrom(AllNewsViewModel::class.java) -> {
                AllNewsViewModel(dataRepository) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}