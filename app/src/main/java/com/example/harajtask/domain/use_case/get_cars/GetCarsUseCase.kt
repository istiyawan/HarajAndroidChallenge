package com.example.harajtask.domain.use_case.get_cars

import com.example.harajtask.common.Resource
import com.example.harajtask.data.remote.dto.toHaraj
import com.example.harajtask.domain.model.Haraj
import com.example.harajtask.domain.repository.HarajRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class GetCarsUseCase @Inject constructor(
    private val repository:HarajRepository
) {
    operator fun invoke(): Flow<Resource<List<Haraj>>> = flow {
        try {
            emit(Resource.Loading<List<Haraj>>())
            val cars = repository.carList().map{it.toHaraj()}
            emit(Resource.Success<List<Haraj>>(cars))
        } catch (e: HttpException){
            emit(Resource.Error<List<Haraj>>(e.localizedMessage?:"An unexpected error occured"))
        } catch (e:IOException){
            emit(Resource.Error<List<Haraj>>("Couldn't reach server. Check your internet connection"))
        }
    }
}