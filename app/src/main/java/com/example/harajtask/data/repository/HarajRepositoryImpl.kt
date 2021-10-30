package com.example.harajtask.data.repository

import com.example.harajtask.data.remote.HarajCarsApi
import com.example.harajtask.data.remote.dto.HarajDto
import com.example.harajtask.data.remote.dto.HarajDtoDetail
import com.example.harajtask.domain.repository.HarajRepository
import javax.inject.Inject

class HarajRepositoryImpl @Inject constructor (
    private val api: HarajCarsApi
    ):HarajRepository{

    override suspend fun carList(): List<HarajDto> {
        return api.carList()
    }

    override suspend fun carDetail(title: String): HarajDtoDetail {
        return api.carDetail(title)
    }

}
