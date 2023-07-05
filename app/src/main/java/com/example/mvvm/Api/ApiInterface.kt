package com.example.mvvm.Api

import com.example.mvvm.Model.ProductModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("products")
    suspend fun getdata():Response<List<ProductModel>>
}