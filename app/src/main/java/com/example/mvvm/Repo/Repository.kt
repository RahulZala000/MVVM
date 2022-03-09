package com.example.mvvm.Repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm.Api.APIinterface
import com.example.mvvm.Api.RetrofitApi
import com.example.mvvm.Model.MyDataModel

class Repository(var retro: APIinterface) {

    var userdata= MutableLiveData<MyDataModel>()
    var liveData:LiveData<MyDataModel> = userdata


    fun getdatarespo(): LiveData<List<MyDataModel>> {
        return retro.getdata()
    }


}