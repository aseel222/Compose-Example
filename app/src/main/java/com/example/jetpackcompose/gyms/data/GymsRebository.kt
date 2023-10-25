package com.example.jetpackcompose.gyms.data

import com.example.jetpackcompose.GymsApplication
import com.example.jetpackcompose.gyms.data.local.GymsDAO
import com.example.jetpackcompose.gyms.data.remote.GymsApiService
import com.example.jetpackcompose.gyms.data.local.GymsDataBase
import com.example.jetpackcompose.gyms.data.local.LocalGym
import com.example.jetpackcompose.gyms.data.local.LocalGymFavState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GymsRebository @Inject constructor(    private val apiService: GymsApiService,
                                             private val gymsDAO:GymsDAO,
){

    suspend fun getallgyms()= withContext(Dispatchers.IO){
        try {
            getgymsfromremotedb()
        }catch (ex:Exception){

            if(gymsDAO.getAll().isEmpty()){
                throw Exception("something went wrong")
            }

        }
        gymsDAO.getAll()
    }

     suspend fun getgymsfromremotedb()
         {
            val gyms= apiService.getgyms()
            val favgymlist=gymsDAO.getFavouriteGyms()
            gymsDAO.addAll(gyms.map { LocalGym(it.id,it.name,it.place,it.isopen) })
            gymsDAO.updateAll(favgymlist.map { LocalGymFavState(id = it.id,true) })
        }


    suspend fun togglefavgym(gymid:Int,newfavstate:Boolean)= withContext(Dispatchers.IO){
        gymsDAO.updatefav(LocalGymFavState(id=gymid,fav = newfavstate))
        return@withContext gymsDAO.getAll()
    }
}