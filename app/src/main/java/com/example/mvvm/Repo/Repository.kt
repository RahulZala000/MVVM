package com.example.mvvm.Repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm.Api.APIinterface
import com.example.mvvm.Model.ProductModel
import com.example.mvvm.Room_Database.DbModule
import com.example.mvvm.Room_Database.RoomDb
import com.example.mvvm.Room_Database.UserDao

import javax.inject.Inject

class Repository @Inject constructor(var retro: APIinterface,var db:RoomDb) {

    var userdata= MutableLiveData<List<ProductModel>>()

    suspend fun getdataapi() {
       var res=retro.getdata()

        if(res.isSuccessful && res.body()!=null)
        {
            userdata.postValue(res.body())
           // db.userdao().insertdata(res.body()!!)
        }
    }

    fun getdatadb(): List<ProductModel>
    {
        return db.userdao().getdata()
    }
}