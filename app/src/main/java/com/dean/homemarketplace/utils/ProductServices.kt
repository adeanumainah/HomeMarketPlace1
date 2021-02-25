package com.dean.homemarketplace.utils

import com.dean.homemarketplace.model.ProductItem
//import com.dean.homemarketplace.model.ResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ProductServices {
    //dari nama vscode
    @get:GET("person/get/")
    val product: Call<List<ProductItem>>

}