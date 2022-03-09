package com.example.mvvm.Api

import androidx.lifecycle.LiveData
import com.example.mvvm.Model.MyDataModel
import retrofit2.http.GET

interface APIinterface {


    @GET("photos")
    fun getdata():LiveData<List<MyDataModel>>

}