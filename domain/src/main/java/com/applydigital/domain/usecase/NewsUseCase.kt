package com.applydigital.domain.usecase

import com.applydigital.core.result.State
import com.applydigital.domain.model.News
import com.applydigital.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsUseCase @Inject constructor(
    private val repository: NewsRepository
) : NewsRepository {
    override suspend fun fetchNews(): Flow<State<News>> {
        return repository.fetchNews()
    }

    override fun deleteNewsItem(newsId: Long) {
        return repository.deleteNewsItem(newsId)
    }


}
