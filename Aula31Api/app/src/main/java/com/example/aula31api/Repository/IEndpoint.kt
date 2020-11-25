package com.example.aula31api.Repository

import com.example.aula31api.model.ApiResponseModel
import com.example.aula31api.model.CharacterModel
import com.example.aula31api.model.LocationModel
import com.example.aula31api.model.RickMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IEndpoint {

    @GET("location")
    fun obterLocalizacao(): retrofit2.Call<RickMortyResponse<LocationModel>>

    interface CharacterEndpoint {

        @GET("character")
        fun obterPersonagens(): Call<ApiResponseModel<CharacterModel>>

        @GET("character/{id}")
        fun obterDetalhe(@Path("id") id: Int): Call<CharacterModel>
    }
}