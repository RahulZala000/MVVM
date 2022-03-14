package com.example.mvvm.di

import android.content.Context
import com.example.mvvm.MainActivity
import com.example.mvvm.Room_Database.DbModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton


@Singleton
@Component(modules=[NetworkModule::class,DbModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory
    {
        fun create(@BindsInstance context: Context):ApplicationComponent
    }
}