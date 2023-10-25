package com.example.jetpackcompose.gyms.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName



data class Gym(

    val id:Int,

    val name:String,


    val place:String,

    val isopen:Boolean,

    val fav:Boolean=false)


