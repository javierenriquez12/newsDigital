package com.applydigital.data.entity

import kotlinx.serialization.SerialName

data class ErrorEntity(
    @SerialName("errorCode")
    val errorCode: String,
    @SerialName("errorMessage")
    val errorMessage: String
)