package com.example.jetpackcompose


val listofgyms= listOf<Gym>(
    Gym(1,"hdhdhh","hdddddddddddddddddddddddddbhcyyffyfyfyfdyf,egypt"),
    Gym(2,"hdhdhh","hdddddddddddddddddddddddddbhcyyffyfyfyfdyf,egypt")
    ,Gym(3,"hdhdhh","hdddddddddddddddddddddddddbhcyyffyfyfyfdyf,egypt"), Gym(6,"hdhdhh","hdddddddddddddddddddddddddbhcyyffyfyfyfdyf,egypt"),
    Gym(4,"hdhdhh","hdddddddddddddddddddddddddbhcyyffyfyfyfdyf,egypt"), Gym(7,"hdhdhh","hdddddddddddddddddddddddddbhcyyffyfyfyfdyf,egypt"),
    Gym(5,"hdhdhh","hdddddddddddddddddddddddddbhcyyffyfyfyfdyf,egypt"), Gym(8,"hdhdhh","hdddddddddddddddddddddddddbhcyyffyfyfyfdyf,egypt")
)

data class Gym(val id:Int,val name:String,val place:String,var fav:Boolean=false)