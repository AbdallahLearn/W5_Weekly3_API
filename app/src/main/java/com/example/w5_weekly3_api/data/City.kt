package com.example.w5_weekly3_api.data

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("country") val country: String,
    @SerializedName("state") val state: String
)

//data class CityRequest(
//    val country: String, // Name of the country
//    val state: String    // Name of the state
//)