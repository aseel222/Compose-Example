package com.example.jetpackcompose.api

import com.example.jetpackcompose.Gym
import retrofit2.Call
import retrofit2.http.GET

interface GymsApiService {
    @GET("gyms.json")
    fun getgyms():Call<List<Gym>>
}