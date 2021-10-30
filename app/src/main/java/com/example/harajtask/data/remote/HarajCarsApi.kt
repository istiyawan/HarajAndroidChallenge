package com.example.harajtask.data.remote

import com.example.harajtask.data.remote.dto.HarajDto
import com.example.harajtask.data.remote.dto.HarajDtoDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface HarajCarsApi   {

    @GET("/")
    suspend fun carList(): List<HarajDto>

    @GET("/{title}")
    suspend fun carDetail(@Path("title") title:String): HarajDtoDetail
}

