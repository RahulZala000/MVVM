package com.example.mvvm.di

import com.example.mvvm.MainActivity
import dagger.Component
import dagger.Module
import javax.inject.Singleton


@Singleton
@Component(modules=[NetworkModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
}