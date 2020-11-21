package com.example.chucknorrisapp.listagem.model.repository

import com.example.chucknorrisapp.data.api.NetworkUtils
import com.example.chucknorrisapp.listagem.model.model.JokesModel
import retrofit2.http.GET
import retrofit2.http.Query

interface JokesEndpoint {

    @GET("random")
    suspend fun getJokes(@Query("category") category: String?): JokesModel

    companion object {
        val endpoint: JokesEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(JokesEndpoint::class.java)
        }
    }
}