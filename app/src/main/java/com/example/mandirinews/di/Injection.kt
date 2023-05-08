package com.example.mandirinews.di

import com.example.mandirinews.data.Repository
import com.example.mandirinews.data.remote.RemoteDataSource

object Injection {
    fun provideRepository(): Repository {

        val remoteDataSource = RemoteDataSource.getInstance()

        return Repository.getInstance(remoteDataSource)
    }
}