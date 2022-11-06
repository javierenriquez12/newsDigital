package com.applydigital.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.applydigital.data.source.local.entity.NewsEntityDao

@Database(entities = [NewsEntityDao::class], version = 1, exportSchema = false)
abstract class NewsDB : RoomDatabase() {
    abstract fun newsDao() : NewsDao
}