package com.example.chucknorrisapp.model.repository

import com.example.chucknorrisapp.data.api.NetworkUtils
import com.example.chucknorrisapp.data.model.ResponseModel
import com.example.chucknorrisapp.model.model.CategoriesModel
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoriaEndpoint {

    @GET("categories")
    suspend fun obterCategoria(@Query("type") type: String, @Query("page") page: Int = 1): ResponseModel<CategoriesModel>

    companion object {
        val endpoint: CategoriaEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(CategoriaEndpoint::class.java)
        }
    }
}