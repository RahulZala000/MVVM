package com.example.mvvm.di

import android.content.Context
import androidx.room.Room
import com.example.mvvm.Api.ApiInterface
import com.example.mvvm.BuildConfig
import com.example.mvvm.Room_Database.RoomDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
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
            .baseUrl(BuildConfig.BASE_URL)
            .client(providerHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getdatabase(context: Context): RoomDb
    {
        return Room.databaseBuilder(context, RoomDb::class.java,"DbApp").allowMainThreadQueries().build()
    }

    @Singleton
    @Provides
    fun Apidata(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
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

