package com.example.jetpackcompose.gyms.data.di

import android.content.Context
import androidx.room.Room
import com.example.jetpackcompose.gyms.data.local.GymsDAO
import com.example.jetpackcompose.gyms.data.local.GymsDataBase
import com.example.jetpackcompose.gyms.data.remote.GymsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GymsDataModule {
    @Provides

    fun provideapiservie(retrofit: Retrofit):GymsApiService{
        return retrofit.create(GymsApiService::class.java)
    }
    @Provides
    @Singleton
    fun provideretrofit():Retrofit{
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://cairo-gym-e23fb-default-rtdb.firebaseio.com/")
            .build()
    }
    @Provides
    fun providedao(dp:GymsDataBase):GymsDAO{
      return dp.dao
    }
    @Singleton
    @Provides
    fun provideroomdb(@ApplicationContext context : Context ):GymsDataBase{
       return Room.databaseBuilder(context.applicationContext, GymsDataBase::class.java,"gyms_database")
            .fallbackToDestructiveMigration()
            .build()

    }
}