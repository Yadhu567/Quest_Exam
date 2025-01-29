package com.example.examapplication2

import com.google.gson.annotations.SerializedName

class NewsEntity(
    @SerializedName("pagination") val pagination: Pagination,
    @SerializedName("data") val data: List<Article>
) {
    data class Pagination(
        @SerializedName("limit") val limit: Double,
        @SerializedName("offset") val offset: Double,
        @SerializedName("count") val count: Double,
        @SerializedName("total") val total: Double
    )

    data class Article(
        @SerializedName("title") val title: String,
        @SerializedName("description") val description: String,
        @SerializedName("category") val category: String,
        @SerializedName("country") val country: String
    )
}