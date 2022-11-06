package com.applydigital.data.di

import android.content.Context
import com.applydigital.data.repository.NewsRepositoryImpl
import com.applydigital.data.source.local.NewsDataSourceLocal
import com.applydigital.data.source.remote.ApiService
import com.applydigital.data.source.remote.NewsDataSourceRemote
import com.applydigital.data.source.remote.NewsDataSourceRemoteImpl
import com.applydigital.data.util.NetworkConnectivity
import com.applydigital.data.util.NetworkValidate
import com.applydigital.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
class NetModule {

    @Provides
    fun provideNetworkConnectivity(@ApplicationContext context: Context): NetworkConnectivity =
        NetworkValidate(context)

    @Provides
    fun provideDataSource(
        apiService: ApiService,
        networkConnectivity: NetworkConnectivity
    ): NewsDataSourceRemote =
        NewsDataSourceRemoteImpl(apiService, networkConnectivity)


    @Provides
    fun provideRepository(
        newsDataSourceRemote: NewsDataSourceRemote,
        newsDataSourceLocal: NewsDataSourceLocal
    ): NewsRepository =
        NewsRepositoryImpl(newsDataSourceRemote, newsDataSourceLocal)
}