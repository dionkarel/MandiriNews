@file:Suppress("FunctionName")

package com.example.mandirinews.utils

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object Utils {
    fun getCountry(): String {
        val locale = Locale.getDefault()
        val strCountry = locale.country
        return strCountry.lowercase(Locale.getDefault())
    }

    @SuppressLint("SimpleDateFormat")
    fun DateFormat(dateNews: String?): String? {
        val isDate: String?
        val dateFormat = SimpleDateFormat("dd MMMM, yyyy", Locale(getCountry()))
        isDate = try {
            val date = dateNews?.let { SimpleDateFormat("yyyy-MM-dd").parse(it) }
            date?.let { dateFormat.format(it) }
        } catch (e: ParseException) {
            e.printStackTrace()
            dateNews
        }
        return isDate
    }
}