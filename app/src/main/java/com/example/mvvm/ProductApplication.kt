package com.example.mvvm

import android.app.Application
import com.example.mvvm.di.ApplicationComponent
import com.example.mvvm.di.DaggerApplicationComponent
import dagger.Component
import dagger.internal.MapProviderFactory.builder
import dagger.internal.SetFactory.builder


class ProductApplication : Application() {

    lateinit var appcom:ApplicationComponent

    @Override
    override fun onCreate() {
        super.onCreate()

        appcom=DaggerApplicationComponent.

    }

}