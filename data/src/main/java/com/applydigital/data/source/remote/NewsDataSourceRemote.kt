package com.applydigital.data.source.remote

import com.applydigital.data.entity.NewsEntity
import com.applydigital.domain.model.News
import kotlinx.coroutines.flow.Flow

interface NewsDataSourceRemote {
    suspend fun fetchNews(): Flow<StateRemoteResponse<NewsEntity>>
}