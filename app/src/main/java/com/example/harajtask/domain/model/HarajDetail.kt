package com.example.harajtask.domain.model

data class HarajDetail(
    val body: String,
    val city: String,

    val commentCount: Int,
    val date: String,
    val thumbURL: String,
    val title: String,
    val username: String
)
