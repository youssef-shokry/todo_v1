package com.route.todoappc42.ui.utils


import android.app.TimePickerDialog
import android.content.Context
import java.util.Calendar

fun showTimePicker(
    context: Context,
    selectedDate: Calendar,
    onTimeSelected: (Calendar) -> Unit
) {
    val picker = TimePickerDialog(
        context,
        { _, hour, minute ->
            selectedDate[Calendar.HOUR_OF_DAY] = hour
            selectedDate[Calendar.MINUTE] = minute
            onTimeSelected(selectedDate)
        },
        selectedDate[Calendar.HOUR_OF_DAY],
        selectedDate[Calendar.MINUTE],
        true // 24-hour format
    )
    picker.show()
}