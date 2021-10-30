package com.example.harajtask.presentation.car_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harajtask.common.Constants
import com.example.harajtask.common.Resource
import com.example.harajtask.domain.use_case.get_car.GetCarUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CarDetailViewModel @Inject constructor(
    private val getCarUseCase: GetCarUseCase,
    savedStateHandle: SavedStateHandle
):ViewModel() {

    private val _state = mutableStateOf(CarDetailState())
    val state: State<CarDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_TITLE)?.let { title ->
            getCar(title)
        }
    }

    private fun getCar(title: String){
        getCarUseCase(title).onEach { result->
            when(result){
                is Resource.Success -> {
                    _state.value = CarDetailState(car = result.data)
                }
                is Resource.Error -> {
                    _state.value = CarDetailState(
                        error = result.message?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CarDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}