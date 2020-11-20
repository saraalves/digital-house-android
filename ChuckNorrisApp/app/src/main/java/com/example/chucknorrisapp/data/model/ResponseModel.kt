package com.example.chucknorrisapp.data.model

import androidx.annotation.Keep

@Keep
data class ResponseModel<String> (
    val results: List<String>
)