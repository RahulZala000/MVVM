package com.example.mvvm.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.Model.MyDataModel
import com.example.mvvm.Repo.Repository

class DataViewModel(var repo: Repository) :ViewModel() {

    fun viewgetdata():LiveData<List<MyDataModel>>
    {
        return repo.getdatarespo()
    }
}