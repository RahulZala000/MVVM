package com.example.mvvm.Repo

import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.util.Util
import com.example.mvvm.Api.APIinterface
import com.example.mvvm.Model.ProductModel
import com.example.mvvm.Room_Database.DbModule
import com.example.mvvm.Room_Database.RoomDb
import com.example.mvvm.Room_Database.UserDao
import com.example.mvvm.di.NetworkModule
import com.example.mvvm.utils.NetworkCheck

import javax.inject.Inject

class Repository @Inject constructor(var retro: APIinterface,var db:RoomDb,var context: Context) {

    var userdata= MutableLiveData<List<ProductModel>>()


    suspend fun getdataapi() {


        if (NetworkCheck.isOnline(context)) {
            var res = retro.getdata()
            if (res.isSuccessful && res.body() != null) {
                Toast.makeText(context, "Online", Toast.LENGTH_SHORT).show()
                userdata.postValue(res.body())
                db.userdao().insertdata(res.body()!!)
            } else {
                Log.d("@Test", "error")
            }
        }
        else {
            userdata.postValue(db.userdao().getdata())
            Log.d("@Test", db.userdao().getdata().toString())
            Toast.makeText(context, "offline", Toast.LENGTH_SHORT).show()
        }

    }
}