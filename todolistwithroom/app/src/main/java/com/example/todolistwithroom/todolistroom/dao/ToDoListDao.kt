package com.example.todolistwithroom.todolistroom.dao

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.Query
import com.example.todolistwithroom.todolistroom.entity.ToDoListEntity

@Dao
interface ToDoListDao {

    @Insert
    suspend fun addTarefa(toDolist: ToDoListEntity)

    @Query("SELECT COUNT(*) FROM ToDoListRoom")
    suspend fun count(): Int

}
