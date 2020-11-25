package com.example.aula31api.model

import com.example.aula31api.model.LocationModel
import com.example.aula31api.model.PageInfoModel

data class RickMortyResponse<T>(
    val info: PageInfoModel,
    val results: List<T>
)