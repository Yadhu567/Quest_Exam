package com.example.examapplication2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class NewsResultActivity : ComponentActivity() {

    private val viewModel by viewModels<NewsViewModel>()
    private lateinit var mRecyclerView: RecyclerView
    private var mAdapter: RecyclerViewAdapter = RecyclerViewAdapter()
    private lateinit var newsDatabase: NewsDatabase
    private lateinit var dao: NewsDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.news_result_layout)

        mRecyclerView = findViewById(R.id.recyclerview)

        mRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(this@NewsResultActivity, RecyclerView.VERTICAL, false)
            adapter = mAdapter
        }

        newsDatabase = Room.databaseBuilder(this, NewsDatabase::class.java, "news-database").build()
        dao = newsDatabase.newsDao()

        val extra = intent.extras

        val source = extra?.getString("sources")
        val country = extra?.getString("country")

        fetchNewsDetails(source.toString(), country.toString())

        viewModel.newsDetails.observe(this) {
            mAdapter.updateData(it)
        }

    }

    private fun fetchNewsDetails(source: String, country: String) {
        viewModel.getNewsDetails(
            source = source,
            country = country,
        )
    }
}