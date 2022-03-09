package com.example.mvvm

import android.app.Application
import com.example.mvvm.Api.RetrofitApi

class DataApplication : Application() {

    lateinit var datarepo:DataApplication

    @Override
    override fun onCreate() {
        super.onCreate()
        intilize()

    }

    private fun intilize() {
        var userapi=RetrofitApi
    }

}