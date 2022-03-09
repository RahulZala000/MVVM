package com.example.mvvm.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {

    var Base="https://jsonplaceholder.typicode.com/"
    fun getapi(): APIinterface {
           var retro= Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(Base).build()

        return retro.create(APIinterface::class.java)
    }
}