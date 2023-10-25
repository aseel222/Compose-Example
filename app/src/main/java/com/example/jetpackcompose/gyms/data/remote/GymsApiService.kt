package com.example.jetpackcompose.gyms.data.remote

import com.example.jetpackcompose.gyms.data.remote.RemoteGym
import retrofit2.http.GET
import retrofit2.http.Query

interface GymsApiService {
    @GET("gyms.json")
   suspend fun getgyms():List<RemoteGym>

    @GET("gyms.json?orderBy=\"id\"")
    suspend fun getgym(@Query("equalTo")id:Int):Map<String, RemoteGym>

}