package com.applydigital.data.source.remote

import com.applydigital.data.entity.NewsEntity
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/api/v1/search_by_date?query=mobile")
    suspend fun fetchNews() : Response<NewsEntity>
}