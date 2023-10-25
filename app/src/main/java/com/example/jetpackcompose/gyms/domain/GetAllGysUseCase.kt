package com.example.jetpackcompose.gyms.domain

import com.example.jetpackcompose.gyms.data.GymsRebository
import javax.inject.Inject

class GetAllGysUseCase @Inject constructor(private val getrepo:GymsRebository) {
    suspend operator fun invoke() :List<Gym>{
       return getrepo.getallgyms().map { Gym(it.id,it.name,it.place,it.isopen,it.fav) }.sortedBy { it.name }

    }

}