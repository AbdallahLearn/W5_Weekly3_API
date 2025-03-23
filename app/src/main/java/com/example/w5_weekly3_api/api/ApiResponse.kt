package com.example.w5_weekly3_api.api

import com.example.w5_weekly3_api.data.Country
import com.google.gson.annotations.SerializedName


data class ApiResponse<T>(
    @SerializedName("error") val error: Boolean,
    @SerializedName("msg") val msg: String,
    @SerializedName("data") val data: T
)