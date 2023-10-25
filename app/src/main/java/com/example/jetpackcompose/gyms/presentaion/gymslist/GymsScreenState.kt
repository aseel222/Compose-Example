package com.example.jetpackcompose.gyms.presentaion.gymslist

import com.example.jetpackcompose.gyms.domain.Gym

data class GymsScreenState(val error:String?=null, val gymslist:List<Gym>, val isloading:Boolean)
