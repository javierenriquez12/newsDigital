package com.applydigital.core.result

sealed class State<out T>(val data: T? = null, val message: String? = null) {
    class Success<out T>(data: T) : State<T>(data)
    class Error<out T>(message: String, data: T? = null) : State<T>(data, message)
}