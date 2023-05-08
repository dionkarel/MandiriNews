package com.example.mandirinews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mandirinews.adapter.AllNewsAdapter
import com.example.mandirinews.adapter.HeadlineNewsAdapter
import com.example.mandirinews.databinding.ActivityMainBinding
import com.example.mandirinews.viewmodel.AllNewsViewModel
import com.example.mandirinews.viewmodel.HeadlineNewsViewModel
import com.example.mandirinews.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var headlineNewsViewModel: HeadlineNewsViewModel
    private lateinit var allNewsViewModel: AllNewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        getHeadlineNews()
        getAllNews()

    }

    private fun getHeadlineNews() {
        val headlineNewsAdapter = HeadlineNewsAdapter()

        binding.rvHeadline.apply {
            setHasFixedSize(true)
            adapter = headlineNewsAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        val factory = ViewModelFactory.getInstance()
        headlineNewsViewModel = ViewModelProvider(this, factory)[HeadlineNewsViewModel::class.java]

        headlineNewsViewModel.getHeadlineNews().observe(this, Observer {
            headlineNewsAdapter.setData(it)
        })
    }

    private fun getAllNews() {
        val allNewsAdapter = AllNewsAdapter()

        binding.rvAllNews.apply {
            setHasFixedSize(true)
            adapter = allNewsAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        val factory = ViewModelFactory.getInstance()
        allNewsViewModel = ViewModelProvider(this, factory)[AllNewsViewModel::class.java]

        allNewsViewModel.getAllNews().observe(this, Observer {
            allNewsAdapter.setData(it)
        })
    }

}