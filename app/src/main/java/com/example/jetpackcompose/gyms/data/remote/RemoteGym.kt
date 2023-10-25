package com.example.jetpackcompose.gyms.data.remote

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName



data class RemoteGym(
    val id:Int,
    @SerializedName("gym_name")
    val name:String,
    @SerializedName("gym_location")

    val place:String,
    @SerializedName("is_open")
    val isopen:Boolean

)



