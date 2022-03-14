package com.example.mvvm

import android.app.Application
import com.example.mvvm.di.ApplicationComponent
import com.example.mvvm.di.DaggerApplicationComponent


class ProductApplication : Application() {

    lateinit var appcom:ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        appcom=DaggerApplicationComponent.builder().build()
    }

}