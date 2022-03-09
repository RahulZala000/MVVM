package com.example.mvvm.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.Model.MyDataModel
import com.example.mvvm.ViewModel.DataViewModel

class DataFactory(var data:List<MyDataModel>):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return DataViewModel(data) as T
    }
}