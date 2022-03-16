package com.example.mvvm.di

import androidx.databinding.ktx.BuildConfig
import com.example.mvvm.Api.APIinterface
import com.example.mvvm.utils.Constants
import dagger.Module
import dagger.Provides
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
object NetworkModule {

    @Singleton
    @Provides
    fun providerHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build()
    }


    @Singleton
    @Provides
    fun Retroprovide(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(providerHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun Apidata(retrofit: Retrofit): APIinterface {
        return retrofit.create(APIinterface::class.java)
    }

}




/*
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun Retroprovide():Retrofit
    {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(providerHttpClient())
            .build()
    }

    @Singleton
    @Provides
    fun Apidata(retrofit: Retrofit):APIinterface
    {
        return retrofit.create(APIinterface::class.java)
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }


    @Singleton
    @Provides
    fun providerHttpClient(): OkHttpClient {

       // val logging = OkHttpClient.Builder().

        return OkHttpClient.Builder()
            .readTimeout(120, TimeUnit.SECONDS)
            .connectTimeout(120, TimeUnit.SECONDS)
          //  .addInterceptor(logging)
            .build()
    }
*/

