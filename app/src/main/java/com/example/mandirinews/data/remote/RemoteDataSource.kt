package com.example.mandirinews.data.remote

import android.content.ContentValues
import android.util.Log
import com.example.mandirinews.data.response.NewsResponse
import com.example.mandirinews.data.response.ResponseItem
import com.example.mandirinews.network.ApiConfig
import com.example.mandirinews.utils.EspressoIdlingResource
import com.example.mandirinews.utils.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }

    fun getHeadlineNews(callback: LoadHeadlineNews) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getHeadlines(Utils.getCountry())
        client.enqueue(object : Callback<ResponseItem> {
            override fun onResponse(
                call: Call<ResponseItem>,
                response: Response<ResponseItem>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { callback.onHeadlineNews(it.articles) }
                    EspressoIdlingResource.decrement()
                } else {
                    Log.e(ContentValues.TAG, "onFailure: ${response.message()}")
                    EspressoIdlingResource.decrement()
                }
            }

            override fun onFailure(call: Call<ResponseItem>, t: Throwable) {
                Log.e(ContentValues.TAG, "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
    }


    fun getAllNews(callback: LoadAllNews) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getAllNews(Utils.getCountry())
        client.enqueue(object : Callback<ResponseItem> {
            override fun onResponse(
                call: Call<ResponseItem>,
                response: Response<ResponseItem>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { callback.onAllNews(it.articles) }
                    EspressoIdlingResource.decrement()
                } else {
                    Log.e(ContentValues.TAG, "onFailure: ${response.message()}")
                    EspressoIdlingResource.decrement()
                }
            }

            override fun onFailure(call: Call<ResponseItem>, t: Throwable) {
                Log.e(ContentValues.TAG, "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
    }


    interface LoadHeadlineNews {
        fun onHeadlineNews(newsResponse: List<NewsResponse>)
    }


    interface LoadAllNews {
        fun onAllNews(newsResponse: List<NewsResponse>)
    }

}