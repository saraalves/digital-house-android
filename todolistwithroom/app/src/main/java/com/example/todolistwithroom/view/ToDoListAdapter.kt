package com.example.todolistwithroom.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistwithroom.R
import com.example.todolistwithroom.todolistroom.entity.ToDoListEntity

class ToDoListAdapter(private val dataSet: List<ToDoListEntity>): RecyclerView.Adapter<ToDoListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_todolist, parent, false)

        return ToDoListViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ToDoListViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item)
    }

}