package com.example.mvvm.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.Model.ProductModel
import com.example.mvvm.Repo.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class DataViewModel(var repo: Repository) :ViewModel() {

    var live:LiveData<List<ProductModel>> = repo.userdata


   init{
       viewModelScope.launch {
         repo.getdataapi()
       }
   }
}