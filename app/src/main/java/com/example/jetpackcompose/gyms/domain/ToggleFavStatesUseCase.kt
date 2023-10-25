package com.example.jetpackcompose.gyms.domain

import com.example.jetpackcompose.gyms.data.GymsRebository
import javax.inject.Inject

class ToggleFavStatesUseCase @Inject constructor(private val getrepo:GymsRebository) {
    suspend operator fun invoke(id:Int,oldsatate:Boolean) :List<Gym>{
        var newstate=oldsatate.not()
       return getrepo.togglefavgym(id,newstate).map { Gym(it.id,it.name,it.place,it.isopen,it.fav) }.sortedBy { it.name }

    }

}