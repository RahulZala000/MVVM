package com.example.mvvm.Room_Database


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm.Model.ProductModel

@Dao
interface UserDao {

    @Query("SELECT * FROM ProductModel")
     fun getdata():List<ProductModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertdata(user:List<ProductModel>)

}