package com.example.w5_weekly3_api.data

import com.google.gson.annotations.SerializedName

data class CityRequest(
    @SerializedName("country") val country: String,
    @SerializedName("state") val state: String
)