package com.example.mvvm.Room_Database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    @Singleton
    @Provides
    fun getdatabase(context:Context):RoomDb
    {
        return Room.databaseBuilder(context,RoomDb::class.java,"DbApp").build()
    }
}