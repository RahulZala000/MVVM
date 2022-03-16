package com.example.mvvm.Factory

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.Repo.Repository
import com.example.mvvm.ViewModel.DataViewModel
import javax.inject.Inject

class ProdDataFactory @Inject constructor(var repo:Repository):ViewModelProvider.Factory {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return DataViewModel(repo) as T
    }

}