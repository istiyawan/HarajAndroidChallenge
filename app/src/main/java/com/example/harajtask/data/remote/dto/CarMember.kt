package com.example.harajtask.data.remote.dto
import com.google.gson.annotations.SerializedName

data class CarMember(
    val title: String,
    val username: String,
    val thumbURL: String,
    val commentCount: Int,
    val city: String,
    val date: Int,
    val body: String,
)
