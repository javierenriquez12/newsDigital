package com.applydigital.data.di

import android.content.Context
import androidx.room.Room
import com.applydigital.data.source.local.NewsDB
import com.applydigital.data.source.local.NewsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DBModule {
    @Singleton
    @Provides
    fun provideDataBase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        NewsDB::class.java,
        "newsDatabase"
    ).build()

    @Provides
    fun provideNewsDao(db: NewsDB) = db.newsDao()
}