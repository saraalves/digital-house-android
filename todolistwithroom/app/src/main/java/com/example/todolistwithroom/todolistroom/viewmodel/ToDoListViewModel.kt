package com.example.todolistwithroom.todolistroom.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.todolistwithroom.todolistroom.entity.ToDoListEntity
import com.example.todolistwithroom.todolistroom.repository.ToDoListRepository
import kotlinx.coroutines.Dispatchers

class ToDoListViewModel(private val repository: ToDoListRepository) : ViewModel() {


    fun addTarefas(toDoListEntity: ToDoListEntity) = liveData(Dispatchers.IO) {
        repository.addTarefa(toDoListEntity)
        emit(true)
    }

    fun count() = liveData(Dispatchers.IO) {
        val count = repository.count()
        emit(count)
    }


    class ToDoListViewModelFactory(private val repository: ToDoListRepository) :
        ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ToDoListViewModel(repository) as T
        }
    }
}

