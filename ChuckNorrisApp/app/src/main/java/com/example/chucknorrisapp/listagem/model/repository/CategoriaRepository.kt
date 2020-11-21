package com.example.chucknorrisapp.listagem.model.repository

class CategoriaRepository {
    private val client =  CategoriaEndpoint.endpoint

    suspend fun obterLista(type: String, page: Int) = client.obterLista(type, page)
}