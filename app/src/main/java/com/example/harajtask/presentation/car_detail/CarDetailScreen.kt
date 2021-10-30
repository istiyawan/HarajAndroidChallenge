package com.example.harajtask.presentation.car_detail

import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter

@Composable
fun CarDetailScreen(
    viewModel: CarDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()){
        state.car?.let{ car ->
            LazyColumn (
                //tes
//                modifier = Modifier.fillMaxSize(),
//                contentPadding = PaddingValues(20.dp)
            ){
                item {

                    Image(
                        painter = rememberImagePainter(car.thumbURL),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth()
                            .size(250.dp, 330.dp)
                    )
                    Row(
                        modifier = Modifier.fillMaxHeight(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = " ${car.title}",
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier.weight(8f),
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "${car.date}",
                        style = MaterialTheme.typography.body2,
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                       text = "${car.username}",
                        style = MaterialTheme.typography.body2,
                    )
                    Text(
                        text = "${car.city}",
                        style = MaterialTheme.typography.body2,
                    )
                    Divider()
                    Text(
                        text = "${car.body}",
                        style = MaterialTheme.typography.body2,
                    )
                }
            }
        }

        if(state.error.isNotBlank()){
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}