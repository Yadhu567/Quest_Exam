package com.example.examapplication2.roomdb

import androidx.room.Dao
import androidx.room.Upsert

@Dao
interface NewsDao {
    @Upsert
    fun insert(news: News)
}
