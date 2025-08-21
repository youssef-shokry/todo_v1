package com.route.todoappc42.ui.utils

import android.app.DatePickerDialog
import android.content.Context
import java.util.Calendar

fun showDatePicker(
    context: Context,
    selectedDate: Calendar,
    onDateSelected: (Calendar) -> Unit
) {
    val picker = DatePickerDialog(
        context,
        { _, year, month, day ->
            selectedDate[Calendar.YEAR] = year
            selectedDate[Calendar.MONTH] = month
            selectedDate[Calendar.DAY_OF_MONTH] = day
            onDateSelected(selectedDate)
        },
        selectedDate[Calendar.YEAR],
        selectedDate[Calendar.MONTH],
        selectedDate[Calendar.DAY_OF_MONTH]
    )
    picker.show()
}
