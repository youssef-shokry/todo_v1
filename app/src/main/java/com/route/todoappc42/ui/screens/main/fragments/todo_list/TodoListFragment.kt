package com.route.todoappc42.ui.screens.main.fragments.todo_list


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.RoomDatabase
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.route.todoappc42.database.MyDatabase
import com.route.todoappc42.databinding.FragmentTodoListBinding
import com.route.todoappc42.ui.model.Todo

class TodoListFragment : BottomSheetDialogFragment() {

    lateinit var binding: FragmentTodoListBinding
    var adapter = TodosAdapter(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTodosRecycler()
        refreshTodosList()
    }


    fun refreshTodosList() {
        val todos = MyDatabase.getInstance().getTodoDao().getAllTodos()
        adapter.submitList(todos)
    }

    private fun initTodosRecycler() {
        adapter.itemClickListener = object : TodosAdapter.ItemClickListener {
            override fun onItemClick(todo: Todo) {
            }

            override fun onDoneClick(todo: Todo) {
            }

            override fun onDeleteClick(todo: Todo) {
                MyDatabase.getInstance().getTodoDao().deleteTodo(todo)
                refreshTodosList()
            }

        }
        binding.todosRecycler.adapter = adapter
    }

}
