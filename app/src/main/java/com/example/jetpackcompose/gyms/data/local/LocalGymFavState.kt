package com.example.jetpackcompose.gyms.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName



@Entity
data class LocalGymFavState(
    @ColumnInfo(name = "gym_id")
    @PrimaryKey
    val id:Int,

    @ColumnInfo("fav")
    val fav:Boolean=false)


