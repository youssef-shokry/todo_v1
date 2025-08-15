package com.route.todoappc42.ui.utils

import java.util.Calendar

fun Calendar.getFormattedDate(): String{
    var year = get(Calendar.YEAR)
    var month = get(Calendar.MONTH) + 1
    var day = get(Calendar.DAY_OF_MONTH)
    return "$year / $month / $day"
}

fun Calendar.getFormattedTime(): String{
    var hour = get(Calendar.HOUR_OF_DAY)
    var minute = get(Calendar.MINUTE)
    return "$hour:$minute"
}

fun Int.isOdd(): Boolean{
    return this % 2 == 1
}