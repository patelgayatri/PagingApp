package com.techand.pagingapp.data.model

import android.webkit.WebStorage

data class  CharResult(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val origin: WebStorage.Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)