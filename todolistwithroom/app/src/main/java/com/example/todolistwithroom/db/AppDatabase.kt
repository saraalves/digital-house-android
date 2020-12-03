package com.example.todolistwithroom.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todolistwithroom.todolistroom.dao.ToDoListDao
import com.example.todolistwithroom.todolistroom.entity.ToDoListEntity

@Database(
    entities = [ToDoListEntity::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun toDolistDao(): ToDoListDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "toDoListRoom"
                ).build()
            }
            return INSTANCE!!
        }
    }
}