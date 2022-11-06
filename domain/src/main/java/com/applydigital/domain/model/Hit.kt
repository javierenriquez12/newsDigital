package com.applydigital.domain.model

data class Hit(
    val author: String,
    val commentText: String,
    val createdAt: String,
    val storyTitle: String,
    val storyUrl: String,
    val createdAtI: Long,
    val parentId: Long?,
    val isDeleted: Int = 0
)