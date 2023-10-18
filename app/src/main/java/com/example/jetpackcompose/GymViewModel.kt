package com.example.jetpackcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.jetpackcompose.api.GymsApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class GymViewModel(private val stateHandle: SavedStateHandle):ViewModel(){
    var state =
        mutableStateOf(emptyList<Gym>())
    private var apiService:GymsApiService
  init  {
        var retrofit:Retrofit=Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://cairo-gym-e23fb-default-rtdb.firebaseio.com/").build()
      apiService=retrofit.create(GymsApiService::class.java)
      getgyms()
    }


      fun getgyms(){
         apiService.getgyms().enqueue(object :Callback<List<Gym>>{
             override fun onResponse(call: Call<List<Gym>>, response: Response<List<Gym>>) {
                 response.body()?.let {
                     state.value=it.restoreselectedgym()
                 }
             }

             override fun onFailure(call: Call<List<Gym>>, t: Throwable) {
                 t.printStackTrace()
             }

         })
         }

    fun togglestate(gymid:Int){
        val gyms=state.value.toMutableList()
        val itemindex=gyms.indexOfFirst {it.id==gymid }
        gyms[itemindex]=gyms[itemindex].copy(fav =!gyms[itemindex].fav)
        storeselectedgym(gyms[itemindex])
        state.value=gyms

    }
    private fun storeselectedgym(gym:Gym){
        val savehandlelist=stateHandle.get<List<Int>?>(FAV_IDS).orEmpty().toMutableList()
        if(gym.fav) savehandlelist.add(gym.id)
        else savehandlelist.remove(gym.id)
        stateHandle[FAV_IDS]=savehandlelist

    }
    private fun List<Gym>.restoreselectedgym():List<Gym> {

        stateHandle.get<List<Int>?>(FAV_IDS)?.let { savedids ->
            savedids.forEach { id ->
                this.find { it ->
                    it.id == id

                }?.fav = true
            }
        }
        return this
    }
companion object {
    const val FAV_IDS="favgymsid"
}

}