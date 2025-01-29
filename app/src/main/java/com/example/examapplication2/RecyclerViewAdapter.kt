package com.example.examapplication2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewHolder>() {

    private var newsModelList = listOf<NewsModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val mContext = parent.context
        val layoutInflater = LayoutInflater.from(mContext)
        val view = layoutInflater.inflate(R.layout.recycler_view_item, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsModelList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val newsModel = newsModelList[position]
        holder.textView1.text = newsModel.title
        holder.textView2.text = newsModel.description
        holder.textView3.text = newsModel.category
    }

    fun updateData(newsModel: List<NewsModel>) {
        newsModelList = newsModel
        notifyDataSetChanged()
    }
}