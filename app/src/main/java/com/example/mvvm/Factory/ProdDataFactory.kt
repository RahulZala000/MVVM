package com.example.mvvm.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.Repo.Repository
import com.example.mvvm.ViewModel.DataViewModel
import javax.inject.Inject

class ProdDataFactory @Inject constructor(var repo:Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return DataViewModel(repo) as T
    }

}