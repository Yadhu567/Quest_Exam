package com.example.examapplication2

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [News::class], version = 1, exportSchema = true)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}