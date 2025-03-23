package com.example.w5_weekly3_api.data

import com.google.gson.annotations.SerializedName

data class State(
    @SerializedName("name") val name: String,
    @SerializedName("state_code") val stateCode: String
)