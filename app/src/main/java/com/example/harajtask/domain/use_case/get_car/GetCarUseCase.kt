package com.example.harajtask.domain.use_case.get_car

import com.example.harajtask.common.Resource
import com.example.harajtask.data.remote.dto.harajDetail
import com.example.harajtask.data.remote.dto.toHaraj
import com.example.harajtask.domain.model.Haraj
import com.example.harajtask.domain.model.HarajDetail
import com.example.harajtask.domain.repository.HarajRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class GetCarUseCase @Inject constructor(
    private val repository:HarajRepository
) {
    operator fun invoke(title: String): Flow<Resource<HarajDetail>> = flow {
        try {
            emit(Resource.Loading<HarajDetail>())
            val car = repository.carDetail(title).harajDetail()
            emit(Resource.Success<HarajDetail>(car))
        } catch (e: HttpException){
            emit(Resource.Error<HarajDetail>(e.localizedMessage?:"An unexpected error occured"))
        } catch (e:IOException){
            emit(Resource.Error<HarajDetail>("Couldn't reach server. Check your internet connection"))
        }
    }
}