package com.example.mvvm.Repo

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.mvvm.Api.APIinterface
import com.example.mvvm.Model.APIResponse
import com.example.mvvm.Model.ArticleModelResponse
import com.example.mvvm.Room_Database.RoomDb
import com.example.mvvm.utils.NetworkCheck

import javax.inject.Inject


class Repository @Inject constructor(var retro: APIinterface,var db: RoomDb,var context: Context) {

    var userdata= MutableLiveData<List<APIResponse>>()
    var onlinedata= MutableLiveData<ArticleModelResponse>()

    suspend fun getdataapi() {

        if (NetworkCheck.isOnline(context)) {
            var res = retro.getData(apiKey = "a6dcb214eb204e61ab5cea48eefcc62d",q="IT", from = "2022-07-20", sortBy = "publishedAt")
            if (res.isSuccessful && res.body() != null) {
                Toast.makeText(context, "Online", Toast.LENGTH_SHORT).show()
                onlinedata.postValue(res.body())
              //  db.userdao().insertdata(res.body()!!)
            } else {
                Log.d("@Test", "error")
            }
        }
        else {
         //   userdata.postValue(db.userdao().getdata())
         //   Log.d("@Test", db.userdao().getdata().toString())
            Toast.makeText(context, "offline", Toast.LENGTH_SHORT).show()
        }

    }
}