package com.route.todoappc42.ui.screens.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.room.Room
import androidx.room.RoomDatabase
import com.route.todoappc42.R
import com.route.todoappc42.database.MyDatabase
import com.route.todoappc42.databinding.ActivityMainBinding
import com.route.todoappc42.ui.model.Todo
import com.route.todoappc42.ui.screens.add_todo.AddTodoBottomSheet
import com.route.todoappc42.ui.screens.main.fragments.settings.SettingsFragment
import com.route.todoappc42.ui.screens.main.fragments.todo_list.TodoListFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
        showFragment(todoListFragment)

    }

    val todoListFragment = TodoListFragment()
    private fun initListeners() {
        binding.fab.setOnClickListener {
            val addTodoFragment = AddTodoBottomSheet{
                todoListFragment.refreshTodosList()
            }
            addTodoFragment.show(supportFragmentManager, null)
        }
        binding.bottomNavBar.setOnItemSelectedListener {
            if(it.itemId == R.id.itemList){
            showFragment(todoListFragment)
            }else if(it.itemId == R.id.itemSettings){
                return@setOnItemSelectedListener false
            }
            return@setOnItemSelectedListener true;
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}