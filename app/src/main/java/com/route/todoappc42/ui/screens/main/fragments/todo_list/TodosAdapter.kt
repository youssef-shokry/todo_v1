package com.route.todoappc42.ui.screens.main.fragments.todo_list

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.todoappc42.R
import com.route.todoappc42.databinding.ItemTodoBinding
import com.route.todoappc42.ui.model.Todo

class TodosAdapter(var todos: List<Todo>) : Adapter<TodosAdapter.TodoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todos[position]
        holder.bind(todo)
    }

    override fun getItemCount(): Int = todos.size


    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newsTodos: List<Todo>){
        todos = newsTodos
        notifyDataSetChanged()
    }


    var itemClickListener: ItemClickListener? = null
    interface ItemClickListener{
        fun onItemClick(todo: Todo)

        fun onDoneClick(todo: Todo)

        fun onDeleteClick(todo: Todo)
    }

     inner class TodoViewHolder(val binding: ItemTodoBinding) : ViewHolder(binding.root) {
        fun bind(todo: Todo) {
            binding.itemTodoTitle.text = todo.title
            binding.itemTodoTime.text = todo.description

            binding.dragItem.setOnClickListener {
                Log.e("binding.dragItem.setOnClickListener", "binding.root.setOnClickListener")
                itemClickListener?.onItemClick(todo)
            }
            binding.icDone.setOnClickListener {
                Log.e("binding.icDone.setOnClickListener", "binding.icDone.setOnClickListener")
                itemClickListener?.onDoneClick(todo)
            }
            if(todo.isDone){
                binding.icDone.visibility = View.GONE
                binding.isDoneTV.visibility = View.VISIBLE

                val green = ContextCompat.getColorStateList(binding.itemTodoTitle.context,R.color.green)
                binding.itemTodoTitle.setTextColor(green)
                binding.verticalView.setStrokeColor(green)
                binding.verticalView.setCardBackgroundColor(green)
            }

            binding.deleteView.setOnClickListener {
                Log.e("binding.deleteView.setOnClickListener", "binding.deleteView.setOnClickListener")
                itemClickListener?.onDeleteClick(todo)
            }
        }
    }
}