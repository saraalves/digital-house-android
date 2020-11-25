package com.example.aula31api.model

import com.google.gson.annotations.SerializedName

data class CharacterModel (
    val id: Int,
    @SerializedName("name")
    val nome: String,
    val status: String,
    @SerializedName("origin")
    val origem: OriginModel,
    @SerializedName("episodes")
    val episodios: List<String>
)