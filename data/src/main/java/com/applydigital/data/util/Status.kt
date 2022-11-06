package com.applydigital.data.util

sealed class Status <T>(
    val data: T? = null,
    val errorCode: Int? = null
) {
    class Success<T>(data: T) : Status<T>(data)
    class Loading<T>(data: T? = null) : Status<T>(data)
    class DataError<T>(errorCode: Int) : Status<T>(null, errorCode)
}
