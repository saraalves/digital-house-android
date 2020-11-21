package com.example.chucknorrisapp.listagem.model.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.chucknorrisapp.listagem.model.repository.JokesRepository
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher

class JokesViewModel(private val repository: JokesRepository): ViewModel() {

    fun getJokes(categoria: String) = liveData(Dispatchers.IO) {
        val jokes = repository.getJokes(categoria)

        emit(jokes)
    }

    class JokesViewModelFactory(private  val repository: JokesRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return JokesViewModel(repository) as T
        }

    }
}