package com.example.harajtask.presentation.car_detail

import com.example.harajtask.domain.model.Haraj
import com.example.harajtask.domain.model.HarajDetail

data class CarDetailState(
    val isLoading: Boolean = false,
    val car: HarajDetail? = null,
    val error: String = ""
)
