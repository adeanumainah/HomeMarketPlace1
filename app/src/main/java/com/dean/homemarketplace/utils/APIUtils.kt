package com.dean.homemarketplace.utils

object APIUtils {
    private  const val API_URL = "http://172.24.10.43/houseapp/index.php/person/get"
    val productServices: ProductServices
        get() = RetrofitClient.getClient(API_URL)?.create(ProductServices::class.java)!!
}