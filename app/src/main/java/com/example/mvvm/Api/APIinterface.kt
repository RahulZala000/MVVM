package com.example.mvvm.Api

import com.example.mvvm.Model.APIResponse
import com.example.mvvm.Model.ArticleModelResponse
import com.example.mvvm.Model.ProductModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIinterface {

    @GET("practicaltest/data.php")
    suspend fun getdata():Response<List<APIResponse>>

    @GET("everything")
    suspend fun getData(
        @Query("q") q:String,
        @Query("from")from:String,
        @Query("sortBy")sortBy:String,
        @Query("apiKey")apiKey:String
    ):Response<ArticleModelResponse>
}