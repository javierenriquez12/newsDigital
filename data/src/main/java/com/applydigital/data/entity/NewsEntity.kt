package com.applydigital.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsEntity(
    @SerialName("hits")
    val hits: List<HitEntity>
)