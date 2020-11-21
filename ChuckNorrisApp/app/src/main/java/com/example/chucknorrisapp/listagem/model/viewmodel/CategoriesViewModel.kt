package com.example.chucknorrisapp.listagem.model.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.chucknorrisapp.listagem.model.model.CategoriesModel
import com.example.chucknorrisapp.listagem.model.repository.CategoriesRepository
import kotlinx.coroutines.Dispatchers

class CategoriesViewModel(private val repository: CategoriesRepository): ViewModel() {

    private var _categorias: MutableList<String> = mutableListOf()

    fun obterLista() = liveData(Dispatchers.IO) {

        val response = repository.obterListaCategorias()

        emit(response)

    }

    class CategoriesViewModelFactory(
        private val repository: CategoriesRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CategoriesViewModel(repository) as T
        }
    }
}