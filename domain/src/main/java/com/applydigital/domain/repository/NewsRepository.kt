package com.applydigital.domain.repository

import com.applydigital.core.result.State
import com.applydigital.domain.model.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun fetchNews(): Flow<State<News>>
    fun deleteNewsItem(newsId: Long)
}