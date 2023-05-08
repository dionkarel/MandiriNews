package com.example.mandirinews.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mandirinews.databinding.ListHeadlineBinding
import com.example.mandirinews.data.local.NewsEntity
import com.example.mandirinews.utils.Utils
import java.util.Date

class HeadlineNewsAdapter : RecyclerView.Adapter<HeadlineNewsAdapter.ViewHolder>() {
    private val newsEntity = ArrayList<NewsEntity>()

    fun setData(data: List<NewsEntity>) {
        newsEntity.clear()
        newsEntity.addAll(data)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HeadlineNewsAdapter.ViewHolder {
        val binding =
            ListHeadlineBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newsEntity.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newsEntity[position])
    }

    inner class ViewHolder(private val binding: ListHeadlineBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val context = itemView.context!!
        fun bind(data: NewsEntity) {
            with(binding) {
                tvTitleHeadline.text = data.title
                tvAuthorHeadline.text = data.author
                tvDateHeadline.text = Utils.DateFormat(data.publishedAt)
                Glide.with(context)
                    .load(data.urlToImage)
                    .into(ivHeadline)
            }
        }
    }

}