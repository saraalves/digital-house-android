package com.example.chucknorrisapp.listagem.model.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.chucknorrisapp.listagem.model.model.CategoriesModel
import com.example.chucknorrisapp.listagem.model.repository.CategoriesRepository
import kotlinx.coroutines.Dispatchers

class CategoriesViewModel(private val repository: CategoriesRepository): ViewModel() {

    private lateinit var _categorias: MutableList<String>

    fun obterLista() = liveData(Dispatchers.IO) {

        val response = repository.obterLista()
        _categorias = response as MutableList<String>

        emit(response)

    }

    class PersonagemViewModelFactory(
        private val repository: CategoriesRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CategoriesViewModel(repository) as T
        }
    }
}