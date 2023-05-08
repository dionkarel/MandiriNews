package com.example.mandirinews.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mandirinews.data.local.NewsEntity
import com.example.mandirinews.data.remote.RemoteDataSource
import com.example.mandirinews.data.response.NewsResponse

class Repository constructor(private val remoteDataSource: RemoteDataSource) :
    DataSource {
    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(remoteData: RemoteDataSource): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(remoteData).apply { instance = this }
            }
    }

    override fun getHeadlineNews(): LiveData<List<NewsEntity>> {
        val newsResult = MutableLiveData<List<NewsEntity>>()
        remoteDataSource.getHeadlineNews(object : RemoteDataSource.LoadHeadlineNews {
            override fun onHeadlineNews(newsResponse: List<NewsResponse>) {
                val listNews = ArrayList<NewsEntity>()
                for (response in newsResponse) {
                    val news = NewsEntity(
                        response.author,
                        response.title,
                        response.description,
                        response.url,
                        response.urlToImage,
                        response.publishedAt,
                        response.content
                    )
                    listNews.add(news)
                }
                newsResult.postValue(listNews)
            }
        })
        return newsResult
    }

    override fun getAllNews(): LiveData<List<NewsEntity>> {
        val newsResult = MutableLiveData<List<NewsEntity>>()
        remoteDataSource.getAllNews(object : RemoteDataSource.LoadAllNews {
            override fun onAllNews(newsResponse: List<NewsResponse>) {
                val listNews = ArrayList<NewsEntity>()
                for (response in newsResponse) {
                    val news = NewsEntity(
                        response.author,
                        response.title,
                        response.description,
                        response.url,
                        response.urlToImage,
                        response.publishedAt,
                        response.content,
                    )
                    listNews.add(news)
                }
                newsResult.postValue(listNews)
            }
        })
        return newsResult
    }
}