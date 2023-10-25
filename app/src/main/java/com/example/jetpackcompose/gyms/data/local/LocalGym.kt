package com.example.jetpackcompose.gyms.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName



@Entity(tableName = "gyms")
data class LocalGym(
    @ColumnInfo(name = "gym_id")
    @PrimaryKey
    val id:Int,
    @ColumnInfo(name = "gym_name")
    val name:String,
    @ColumnInfo(name="gym_location")

    val place:String,
    val isopen:Boolean,
    @ColumnInfo("fav")
    val fav:Boolean=false)



