package com.example.mvvm.ViewModel

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.Model.ProductModel
import com.example.mvvm.Repo.Repository
import com.example.mvvm.utils.NetworkCheck
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class DataViewModel @Inject constructor(var repo: Repository) :ViewModel() {

    var live:LiveData<List<ProductModel>> = repo.userdata

  init{
       viewModelScope.launch {
         repo.getdataapi()
       }
   }









}