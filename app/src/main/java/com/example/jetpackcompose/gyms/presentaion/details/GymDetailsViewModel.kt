package com.example.jetpackcompose.gyms.presentaion.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.GymsApplication
import com.example.jetpackcompose.gyms.data.local.GymsDAO
import com.example.jetpackcompose.gyms.data.local.GymsDataBase
import com.example.jetpackcompose.gyms.data.remote.GymsApiService
import com.example.jetpackcompose.gyms.data.local.LocalGym
import com.example.jetpackcompose.gyms.data.remote.RemoteGym
import com.example.jetpackcompose.gyms.domain.Gym
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class GymDetailsViewModel  (savedStateHandle: SavedStateHandle
    ):ViewModel(){

    private var apiService: GymsApiService
    val state=  mutableStateOf<Gym?>(null)

    private val errorhandeler= CoroutineExceptionHandler { coroutineContext, throwable ->
        throwable.printStackTrace()
    }
  init  {
        var retrofit:Retrofit=Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://cairo-gym-e23fb-default-rtdb.firebaseio.com/").build()
      apiService=retrofit.create(GymsApiService::class.java)
      val id=savedStateHandle.get<Int>("gym_id")?:0
      getgym(id)
    }


 fun getgym(id: Int){
    viewModelScope.launch(errorhandeler) {
        state.value=getgymfromdb(id).let { Gym(it.id,it.name,it.place,it.isopen) }
    }

}
    private suspend fun getgymfromdb(id:Int)= withContext(Dispatchers.IO) {
try {
   apiService.getgym(id).values.first().let { RemoteGym(it.id,it.name,it.place,it.isopen) }


}    catch (ex:Exception){
    throw Exception(ex.message)
}

    }


}