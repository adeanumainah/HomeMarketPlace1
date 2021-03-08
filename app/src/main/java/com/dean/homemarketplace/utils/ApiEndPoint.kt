package com.dean.homemarketplace.utils

import com.dean.homemarketplace.model.ResponseHome
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {
    @GET("data")
    fun getData(): Call<ResponseHome>
}