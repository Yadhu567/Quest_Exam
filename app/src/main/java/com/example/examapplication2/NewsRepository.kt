package com.example.examapplication2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRepository {

    suspend fun getNewsInfo(
        source: String,
        country: String,
    ): List<NewsModel> {

        val api = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(NewsApi::class.java)

        return api.getNewsDetail(Constants.API_KEY, source, country).toNewsModel()
    }
}

fun NewsEntity.toNewsModel(): List<NewsModel> {
    return this.data.map { article ->
        NewsModel(
            title = article.title,
            description = article.description,
            category = article.category
        )
    }
}

