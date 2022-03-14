package com.example.mvvm.di

import com.example.mvvm.Api.APIinterface
import com.example.mvvm.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {


    @Singleton
    @Provides
    fun Retroprovide():Retrofit
    {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun Apidata(retrofit: Retrofit):APIinterface
    {
        return retrofit.create(APIinterface::class.java)
    }
}