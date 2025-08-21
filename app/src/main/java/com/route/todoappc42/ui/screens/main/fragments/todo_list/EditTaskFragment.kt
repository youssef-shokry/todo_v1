package com.route.todoappc42.ui.screens.main.fragments.todo_list

import android.app.DatePickerDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.route.todoappc42.databinding.FragmentEditTaskBinding
import androidx.core.graphics.drawable.toDrawable
import com.route.todoappc42.database.MyDatabase
import com.route.todoappc42.ui.model.Todo
import com.route.todoappc42.ui.utils.getFormattedDate
import com.route.todoappc42.ui.utils.getFormattedTime
import com.route.todoappc42.ui.utils.showDatePicker
import com.route.todoappc42.ui.utils.showTimePicker
import java.util.Calendar

class EditTaskFragment(private val todo: Todo) : DialogFragment() {

    private lateinit var binding: FragmentEditTaskBinding
    private var selectedDate : Calendar = Calendar.getInstance()

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            (resources.displayMetrics.widthPixels * 0.9).toInt(), // 90% of screen width
            (resources.displayMetrics.heightPixels * 0.7).toInt() //70% of the screen height
        )
        dialog?.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable()) // keep card corners visible
    }

    interface OnTaskEditedListener{
        fun onTaskEdited()
    }
    var onTaskEditedListener : OnTaskEditedListener? = null

    private fun bindTime() {
        binding.time.text = selectedDate.getFormattedTime()
    }
    private fun bindDate() {
        binding.date.text = selectedDate.getFormattedDate()
    }
    private fun isTitleEdited() : Boolean{
        return !binding.titleEditInput.editText?.text.toString().isEmpty()
    }
    private fun isDescriptionEdited() : Boolean {
        return !binding.descriptionEditInput.editText?.text.toString().isEmpty()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDataAndTime()
        initListeners()
    }

    private fun initDataAndTime() {}

    private fun initListeners() {
        binding.saveButton.setOnClickListener {
            if (isTitleEdited()){
                todo.title = binding.titleEditInput.editText!!.text.toString().trim()
            }
            if (isDescriptionEdited()){
                todo.description = binding.descriptionEditInput.editText!!.text.toString().trim()
            }
            todo.date = selectedDate.timeInMillis
            MyDatabase.getInstance().getTodoDao().updateTodo(todo)
            onTaskEditedListener?.onTaskEdited()
            dismiss()
        }
        binding.SelectedEditDate.setOnClickListener {
            showDatePicker(requireContext(), selectedDate){
                bindDate()
            }
        }
        binding.SelectedEditTime.setOnClickListener {
            showTimePicker(requireContext(), selectedDate){
                bindTime()
            }
        }
    }
}