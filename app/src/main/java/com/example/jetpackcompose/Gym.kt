package com.example.jetpackcompose


val listofgyms= listOf<Gym>(
    Gym("hdhdhh","hdddddddddddddddddddddddddbhcyyffyfyfyfdyf,egypt"),
    Gym("hdhdhh","hdddddddddddddddddddddddddbhcyyffyfyfyfdyf,egypt")
    ,Gym("hdhdhh","hdddddddddddddddddddddddddbhcyyffyfyfyfdyf,egypt"), Gym("hdhdhh","hdddddddddddddddddddddddddbhcyyffyfyfyfdyf,egypt"),
    Gym("hdhdhh","hdddddddddddddddddddddddddbhcyyffyfyfyfdyf,egypt"), Gym("hdhdhh","hdddddddddddddddddddddddddbhcyyffyfyfyfdyf,egypt"),
    Gym("hdhdhh","hdddddddddddddddddddddddddbhcyyffyfyfyfdyf,egypt"), Gym("hdhdhh","hdddddddddddddddddddddddddbhcyyffyfyfyfdyf,egypt")
)

data class Gym(val name:String,val place:String)