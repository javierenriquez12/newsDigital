package com.applydigital.data.mapper

import com.applydigital.data.entity.NewsEntity
import com.applydigital.data.source.local.entity.NewsEntityDao
import com.applydigital.domain.model.Hit
import com.applydigital.domain.model.News

object NewsMapper {

    fun NewsEntityDao.newsDaoToDomain() = Hit(
        author = this.author,
        commentText = this.commentText,
        createdAt = this.createdAt,
        storyTitle = this.storyTitle,
        storyUrl = this.storyUrl,
        createdAtI = this.createdAtI,
        isDeleted = this.isDeleted,
        parentId = this.parentId
    )

    fun NewsEntity.newsToDataLocal() =
        this.hits.filter {
            it.parentId != null
        }.map {
            NewsEntityDao(
                author = it.author,
                commentText = it.commentText ?: "",
                createdAt = it.createdAt,
                storyTitle = it.storyTitle ?: "",
                storyUrl = it.storyUrl ?: "",
                createdAtI = it.createdAtI,
                parentId = it.parentId!!.toLong(),
                isDeleted = 0
            )
        }
}