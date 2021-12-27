package com.techand.pagingapp.data.network

import com.techand.pagingapp.data.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("character")
    suspend fun getDataFromApi(@Query("page")query: Int): ApiResponse
}