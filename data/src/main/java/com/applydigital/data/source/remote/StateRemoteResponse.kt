package com.applydigital.data.source.remote

sealed class StateRemoteResponse<out T>(val data: T? = null, val message: String? = null) {
    class Success<out T>(data: T) : StateRemoteResponse<T>(data)
    class Error<out T>(message: String, data: T? = null) : StateRemoteResponse<T>(data, message)
}