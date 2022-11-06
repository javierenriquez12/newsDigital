package com.applydigital.data.repository

import com.applydigital.core.result.State
import com.applydigital.data.mapper.NewsMapper.newsDaoToDomain
import com.applydigital.data.mapper.NewsMapper.newsToDataLocal
import com.applydigital.data.source.local.NewsDataSourceLocal
import com.applydigital.data.source.remote.NewsDataSourceRemote
import com.applydigital.data.source.remote.StateRemoteResponse
import com.applydigital.domain.model.News
import com.applydigital.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsDataSourceRemote: NewsDataSourceRemote,
    private val newsDataSourceLocal: NewsDataSourceLocal
) : NewsRepository {

    override suspend fun fetchNews(): Flow<State<News>> {

        return flow {
            when (val apiResponse = newsDataSourceRemote.fetchNews().first()) {
                is StateRemoteResponse.Success -> {
                    newsDataSourceLocal.clearNews()
                    newsDataSourceLocal.insertNews(
                        apiResponse.data!!.newsToDataLocal()
                    )
                    emit(
                        State.Success(
                            News(newsDataSourceLocal.fetchNews().first().map {
                                it.newsDaoToDomain()
                            })
                        )
                    )
                }
                is StateRemoteResponse.Error -> {
                    emit(
                        State.Error("PRUEBA",
                            News(newsDataSourceLocal.fetchNews().first().map {
                                it.newsDaoToDomain()
                            })
                        )
                    )
                }
            }
        }
    }

    override fun deleteNewsItem(parentId: Long) {
        newsDataSourceLocal.deleteNewsForId(parentId)
    }
}