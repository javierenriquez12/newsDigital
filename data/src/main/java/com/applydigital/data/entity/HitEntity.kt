package com.applydigital.data.entity


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class HitEntity(
    @SerializedName("author")
    val author: String,
    @SerializedName("comment_text")
    val commentText: String?,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("created_at_i")
    val createdAtI: Long,
    @SerializedName("parent_id")
    val parentId: Int?,
    @SerializedName("story_title")
    val storyTitle: String?,
    @SerializedName("story_url")
    val storyUrl: String?
)