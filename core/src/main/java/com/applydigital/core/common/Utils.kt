package com.applydigital.core.common

import android.util.Log
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object Utils {
    fun transformUtcToLocal(time: String): String? = try {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S'Z'")
        simpleDateFormat.timeZone = TimeZone.getTimeZone("UTC")
        val newSimpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S'Z'")
        newSimpleDateFormat.format(simpleDateFormat.parse(time))
    } catch (e: ParseException) {
        Log.e("Error Date at Whisp", e.message.toString())
        null
    }
}