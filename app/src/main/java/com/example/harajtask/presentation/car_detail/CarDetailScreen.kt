package com.example.harajtask.presentation.car_detail

import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.harajtask.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

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
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(250.dp, 330.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column() {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style= SpanStyle(
                                        color = Color.Green)
                                    ){
                                        append("${car.title}")

                                    }
                                },
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.Right,
                                style = MaterialTheme.typography.h5,
                            )

                            Text(
                                buildAnnotatedString {
                                    withStyle(style= SpanStyle(
                                        color = Color.Gray)
                                    ){
                                        append("${car.date}")
//                                        append("${stringtoDate(car.date)}")

                                    }
                                },
                                style = MaterialTheme.typography.body2,
                                modifier = Modifier.padding(top = 10.dp),

                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {

                                Row() {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_user),
                                        contentDescription = "Location",
                                        modifier = Modifier
                                            .size(15.dp),
                                        tint = Color.Gray

                                    )
                                    Text(
                                        buildAnnotatedString {
                                            withStyle(style= SpanStyle(
                                                color = Color.DarkGray)
                                            ){
                                                append("${car.username}")

                                            }
                                        },

                                        textAlign = TextAlign.Start,
                                        style = MaterialTheme.typography.body2,
                                        modifier = Modifier.padding(start = 5.dp,end = 5.dp)
                                    )


                                }

                                Row() {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_location),
                                        contentDescription = "Location",
                                        modifier = Modifier
                                            .size(15.dp),
                                        tint = Color.Gray

                                    )
                                    Text(
                                        buildAnnotatedString {
                                            withStyle(style= SpanStyle(
                                                color = Color.DarkGray)
                                            ){
                                                append("${car.city}")

                                            }
                                        },

                                        textAlign = TextAlign.End,
                                        style = MaterialTheme.typography.body2,
                                        modifier = Modifier.padding(start = 3.dp)
                                    )

                                }

                            }

                            Text(
                                text = "${car.body}",
                                style = MaterialTheme.typography.body2,
                                modifier = Modifier.padding(top = 30.dp)
                            )
                        }

                    }

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

fun stringtoDate(dates: String): Date {
    val sdf = SimpleDateFormat("EEE, MMM dd yyyy",
        Locale.ENGLISH)
    var date: Date? = null
    try {
        date = sdf.parse(dates)
        println(date)
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return date!!
}