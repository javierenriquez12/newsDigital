package com.applydigital.data.source.local

import com.applydigital.data.source.local.entity.NewsEntityDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsDataSourceLocal @Inject constructor(private val dao: NewsDao) {

    fun fetchNews() : Flow<List<NewsEntityDao>> = dao.fetchNews()

    suspend fun insertNews(news: List<NewsEntityDao>){
        dao.insertNews(news)
    }

    fun deleteNewsForId(parentId: Long){
        dao.deleteForId(parentId)
    }

    suspend fun clearNews(){
        dao.clear()
    }
}