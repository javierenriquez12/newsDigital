package com.applydigital.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
class NewsEntityDao(
    @PrimaryKey
    @ColumnInfo(name = "parentId")
    val parentId: Long? = null,
    @ColumnInfo(name = "author")
    val author: String,
    @ColumnInfo(name = "commentText")
    val commentText: String,
    @ColumnInfo(name = "createdAt")
    val createdAt: String,
    @ColumnInfo(name = "storyTitle")
    val storyTitle: String,
    @ColumnInfo(name = "storyUrl")
    val storyUrl: String,
    @ColumnInfo(name = "createdAtI")
    val createdAtI: Long,
    @ColumnInfo(name = "isDeleted")
    val isDeleted: Int
)