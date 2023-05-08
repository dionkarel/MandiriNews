@file:Suppress("FunctionName")

package com.example.mandirinews.utils

import org.ocpsoft.prettytime.PrettyTime
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object Utils {
    fun getCountry(): String? {
        val locale = Locale.getDefault()
        val strCountry = locale.country
        return strCountry.lowercase(Locale.getDefault())
    }

    fun DateFormat(dateNews: String?): String? {
        val isDate: String?
        val dateFormat = SimpleDateFormat("dd MMMM, yyyy", getCountry()?.let { Locale(it) })
        isDate = try {
            val date = dateNews?.let { SimpleDateFormat("yyyy-MM-dd").parse(it) }
            dateFormat.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
            dateNews
        }
        return isDate
    }
}