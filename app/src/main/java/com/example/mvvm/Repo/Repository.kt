package com.example.mvvm.Repo

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.Api.ApiInterface
import com.example.mvvm.Model.ProductModel
import com.example.mvvm.Room_Database.RoomDb
import com.example.mvvm.utils.NetworkCheck
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

import javax.inject.Inject

@Module
@InstallIn(ViewModelComponent::class)
class Repository @Inject constructor(var retro: ApiInterface, var db:RoomDb, var context: Context) {

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