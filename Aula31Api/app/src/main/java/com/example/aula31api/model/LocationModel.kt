package com.example.aula31api.model

import com.google.gson.annotations.SerializedName

data class LocationModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val nome: String,
    @SerializedName("type")
    val tipo: String,
    @SerializedName("dimension")
    val dimensao: String,
    @SerializedName("residents")
    val urlPersonagem: List<String>
)
