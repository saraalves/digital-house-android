package com.example.chucknorrisapp.listagem.model.repository

class JokesRepository {

    private val client = JokesEndpoint.endpoint

    suspend fun getJokes(category: String?) = client.getJokes(category)
}

