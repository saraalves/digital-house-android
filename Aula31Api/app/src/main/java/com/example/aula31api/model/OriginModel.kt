package com.example.aula31api.model

import com.google.gson.annotations.SerializedName

data class OriginModel (
    @SerializedName("name")
    val nome: String,
    val url: String
)