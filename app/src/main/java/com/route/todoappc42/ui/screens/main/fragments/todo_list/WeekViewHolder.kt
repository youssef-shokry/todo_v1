package com.route.todoappc42.ui.screens.main.fragments.todo_list

import android.view.View
import com.kizitonwose.calendar.view.ViewContainer
import com.route.todoappc42.databinding.CalendarDayLayoutBinding
import com.route.todoappc42.databinding.CalendarWeekHeaderBinding

class WeekViewHolder(view: View) : ViewContainer(view) {
     val week = CalendarWeekHeaderBinding.bind(view).calendarDayName
}