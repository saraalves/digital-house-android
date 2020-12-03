package com.example.todolistwithroom.todolistroom.repository

import com.example.todolistwithroom.todolistroom.dao.ToDoListDao
import com.example.todolistwithroom.todolistroom.entity.ToDoListEntity

class ToDoListRepository(private val toDoListDao: ToDoListDao) {

    suspend fun addTarefa(tarefa: ToDoListEntity) = toDoListDao.addTarefa(tarefa)
    suspend fun count() = toDoListDao.count()
}