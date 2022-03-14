package com.example.mvvm.Room_Database


import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm.Model.ProductModel

@Database(entities = [ProductModel::class],version = 1)
abstract class RoomDb : RoomDatabase(){

    abstract fun userdao():UserDao

    /*companion object {

        var Instant: RoomDb? = null

        fun database(context:Context): RoomDb? {
            if (Instant==null)
            {
                Instant= Room.databaseBuilder(context,RoomDb::class.java,"DbApp").build()
            }
            return Instant
        }
    }*/
}