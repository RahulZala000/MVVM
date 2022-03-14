package com.example.mvvm.Repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm.Api.APIinterface
import com.example.mvvm.Model.ProductModel
import javax.inject.Inject

class Repository @Inject constructor(var retro: APIinterface) {

    var userdata= MutableLiveData<List<ProductModel>>()

    suspend fun getdataapi() {
       var res=retro.getdata()

        if(res.isSuccessful && res.body()!=null)
            userdata.postValue(res.body())
    }
}