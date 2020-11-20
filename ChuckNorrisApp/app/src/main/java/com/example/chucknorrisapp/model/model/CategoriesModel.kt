package com.example.chucknorrisapp.model.model

import com.google.gson.annotations.SerializedName

data class CategoriesModel (
    val id: Int,
    val animal: String,
    @SerializedName("career")
    val carreira: String,
    @SerializedName("celebrity")
    val celebridade: String,
    @SerializedName("dev")
    val desenvolvedor: String,
    @SerializedName("explicit")
    val explicito: String,
    @SerializedName("fashion")
    val moda: String,
    @SerializedName("food")
    val comida: String,
    @SerializedName("history")
    val historia: String,
    @SerializedName("money")
    val dinheiro: String,
    @SerializedName("movie")
    val filme: String,
    @SerializedName("music")
    val musica: String,
    @SerializedName("political")
    val politica: String,
    @SerializedName("religion")
    val religiao: String,
    @SerializedName("science")
    val ciencia: String,
    @SerializedName("sport")
    val esporte: String,
    @SerializedName("travel")
    val viagem: String
)