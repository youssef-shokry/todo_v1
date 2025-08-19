package com.route.todoappc42.ui.screens.main.fragments.todo_list

import android.view.View
import com.kizitonwose.calendar.view.ViewContainer
import com.route.todoappc42.databinding.CalendarDayLayoutBinding

class DayViewHolder(view: View) : ViewContainer(view) {
     val day = CalendarDayLayoutBinding.bind(view).calendarDay
     val name = CalendarDayLayoutBinding.bind(view).calendarDayName
}