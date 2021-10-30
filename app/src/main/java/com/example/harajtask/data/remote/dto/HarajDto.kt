package com.example.harajtask.data.remote.dto

import com.example.harajtask.domain.model.Haraj

data class HarajDto(
    val body: String,
    val city: String,
    val commentCount: Int,
    val date: Int,
    val thumbURL: String,
    val title: String,
    val username: String
)

fun HarajDto.toHaraj():Haraj{
    return Haraj(
        city = city,
        commentCount = commentCount,
        date = date,
        thumbURL = thumbURL,
        title = title,
        username = username
    )
}
