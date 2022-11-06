package com.applydigital.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.applydigital.data.source.local.entity.NewsEntityDao
import com.applydigital.domain.model.News
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Query("SELECT * FROM news WHERE isDeleted = 0")
    fun fetchNews(): Flow<List<NewsEntityDao>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNews(news: List<NewsEntityDao>)

    @Query("UPDATE news set isDeleted = 1 WHERE parentId = :parentId")
    fun deleteForId(parentId: Long)

    @Query("DELETE FROM news WHERE isDeleted = 0")
    suspend fun clear()
}