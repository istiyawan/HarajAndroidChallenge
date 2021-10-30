package com.example.harajtask.presentation.car_list

import com.example.harajtask.domain.model.Haraj

data class CarListState(
    val isLoading: Boolean = false,
    val cars:List<Haraj> = emptyList(),
    val error: String = ""

)
