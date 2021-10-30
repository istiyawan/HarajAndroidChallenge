package com.example.harajtask.presentation.car_list

import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import com.example.harajtask.domain.use_case.get_cars.GetCarsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.harajtask.common.Resource
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class CarListViewModel @Inject constructor(
    private val getCarsUseCase : GetCarsUseCase
):ViewModel() {
    private val _state = mutableStateOf(CarListState())
    val state: State<CarListState> = _state

    init {
        getCars()
    }

    private fun getCars(){
        getCarsUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = CarListState(cars = result.data?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CarListState(
                        error = result.message?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CarListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}