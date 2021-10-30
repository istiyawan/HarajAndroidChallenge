package com.example.harajtask.domain.repository

import com.example.harajtask.data.remote.dto.HarajDto
import com.example.harajtask.data.remote.dto.HarajDtoDetail

interface HarajRepository {
    suspend fun carList(): List<HarajDto>

    suspend fun carDetail(title: String): HarajDtoDetail
}