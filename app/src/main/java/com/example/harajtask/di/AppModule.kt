package com.example.harajtask.di

import com.example.harajtask.common.Constants
import com.example.harajtask.data.remote.HarajCarsApi
import com.example.harajtask.data.repository.HarajRepositoryImpl
import com.example.harajtask.domain.repository.HarajRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHarajApi(): HarajCarsApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HarajCarsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHarajRepository(api: HarajCarsApi): HarajRepository{
        return HarajRepositoryImpl(api)
    }
}