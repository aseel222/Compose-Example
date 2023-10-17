package com.example.jetpackcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GymViewModel:ViewModel(){
    var state =
        mutableStateOf(getgyms())

     private fun getgyms()= listofgyms
    fun togglestate(gymid:Int){
        val gyms=state.value.toMutableList()
        val itemindex=gyms.indexOfFirst {it.id==gymid }
        gyms[itemindex]=gyms[itemindex].copy(fav =!gyms[itemindex].fav)
        state.value=gyms

    }
}