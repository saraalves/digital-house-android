package com.example.todolistwithroom.todolistroom.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ToDoListRoom")
data class ToDoListEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo
    var titulo: String,
    @ColumnInfo
    var descricao: String,
    @ColumnInfo
    var status: Boolean
)