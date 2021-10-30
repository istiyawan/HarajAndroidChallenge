package com.example.harajtask.presentation

sealed class Screen(val route: String){
    object CarListScreen: Screen("car_list_screen")
    object CarDetailScreen: Screen("car_detail_screen")
}
