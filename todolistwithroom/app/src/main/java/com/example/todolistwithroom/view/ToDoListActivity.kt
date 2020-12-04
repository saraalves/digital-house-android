package com.example.todolistwithroom.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todolistwithroom.R

class ToDoListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.toDolistFragment, ToDoListFragment())
            .commit()
    }
}