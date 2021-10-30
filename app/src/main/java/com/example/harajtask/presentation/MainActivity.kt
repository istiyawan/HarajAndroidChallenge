package com.example.harajtask.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.harajtask.presentation.Screen
import com.example.harajtask.presentation.car_detail.CarDetailScreen
import com.example.harajtask.presentation.car_list.CarListScreen
import com.example.harajtask.presentation.car_list.CarListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContent {
            Surface(color= MaterialTheme.colors.background){
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.CarListScreen.route
                ){
                    composable(
                        route = Screen.CarListScreen.route
                    ){
                        CarListScreen(navController)
                    }

                    composable(
                        route = Screen.CarDetailScreen.route + "/{title}"
                    ){
                        CarDetailScreen()
                    }
                }
            }
        }
    }
}