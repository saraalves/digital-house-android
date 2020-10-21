package com.example.gridrickapp.api


import com.google.gson.annotations.SerializedName

data class Localizacao(
    @SerializedName("name")
    var nome: String
)