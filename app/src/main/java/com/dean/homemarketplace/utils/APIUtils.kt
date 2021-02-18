package com.dean.homemarketplace.utils

object APIUtils {
    var API_URL = "http://172.24.10.187/houseapp/index.php/person/get"
    val productServices: ProductServices
        get() = RetrofitClient.getClient(API_URL)?.create(ProductServices::class.java)!!
}