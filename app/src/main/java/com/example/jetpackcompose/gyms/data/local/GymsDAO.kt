package com.example.jetpackcompose.gyms.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface GymsDAO {
   @Query("SELECT * FROM gyms")
    suspend fun getAll():List<LocalGym>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAll(gyms:List<LocalGym>)
    @Update(entity = LocalGym::class)
    suspend fun updatefav(gymsFavState: LocalGymFavState)
@Query("SELECT* FROM gyms WHERE fav=1")
    suspend fun getFavouriteGyms():List<LocalGym>
@Update(entity = LocalGym::class)
    suspend fun updateAll(gymstate:List<LocalGymFavState>)
    @Query("SELECT * FROM gyms WHERE gym_id=:id")
    suspend fun getgymdetails(id:Int): LocalGym
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addgym(gym: LocalGym)



}