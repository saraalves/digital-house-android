package com.example.chucknorrisapp.listagem.model.repository

class CategoriesRepository {
    private val client =  CategoriesEndpoint.endpoint

    suspend fun obterLista() = client.obterListaCategorias()
}