package com.example.harajtask.data.remote.dto

import com.example.harajtask.domain.model.Haraj
import com.example.harajtask.domain.model.HarajDetail

data class HarajDtoDetail(
    val body: String,
    val city: String,
    val commentCount: Int,
    val date: Int,
    val thumbURL: String,
    val title: String,
    val username: String
)

fun HarajDtoDetail.harajDetail(): HarajDetail{
    return HarajDetail(
        body = body,
        commentCount = commentCount,
        city = city,
        date = date,
        thumbURL = thumbURL,
        title = title,
        username = username
    )
}
