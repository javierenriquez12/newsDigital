package com.applydigital.data.source.remote

import com.applydigital.data.entity.NewsEntity
import com.applydigital.data.util.NetworkConnectivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

class NewsDataSourceRemoteImpl @Inject constructor(
    private val apiService: ApiService,
    private val networkConnectivity: NetworkConnectivity
) : NewsDataSourceRemote {

    override suspend fun fetchNews(): Flow<StateRemoteResponse<NewsEntity>> {
        return flow {
            if (networkConnectivity.isConnected()) {
                try {
                    val connect = apiService.fetchNews()
                    if (connect.isSuccessful) {
                        emit(StateRemoteResponse.Success(connect.body()!!))
                    } else {
                        emit(StateRemoteResponse.Error("error"))
                    }
                } catch (e: Exception) {
                    emit(StateRemoteResponse.Error("error"))
                }
            } else {
                emit(StateRemoteResponse.Error("error"))
            }
        }.flowOn(Dispatchers.IO)
    }
}
