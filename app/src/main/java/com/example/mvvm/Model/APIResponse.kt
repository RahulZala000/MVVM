package com.example.mvvm.Model

import androidx.room.Entity
import androidx.room.PrimaryKey


data class APIResponse(

    var id:Int,
    var url:String?,
    var name:String?,
    var size:Long?,
    var popular:Boolean?
)
