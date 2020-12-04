package com.example.todolistwithroom.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistwithroom.R
import com.example.todolistwithroom.todolistroom.entity.ToDoListEntity

class ToDoListViewHolder (view: View): RecyclerView.ViewHolder(view) {

    private val titulo = view.findViewById<TextView>(R.id.txtTodoRecycler)

    fun bind (todo: ToDoListEntity) {
        titulo.text = todo.titulo
    }

}