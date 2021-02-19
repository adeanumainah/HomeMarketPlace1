package com.dean.homemarketplace.utils

object APIUtils {
    var API_URL = "http://192.168.42.230/houseapp/index.php/person/get"
    val productServices: ProductServices
        get() = RetrofitClient.getClient(API_URL)?.create(ProductServices::class.java)!!
}