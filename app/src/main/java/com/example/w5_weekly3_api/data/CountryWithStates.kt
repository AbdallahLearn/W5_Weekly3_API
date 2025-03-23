package com.example.w5_weekly3_api.data

import com.google.gson.annotations.SerializedName

data class CountryWithStates(
    @SerializedName("name") val name: String,
    @SerializedName("iso3") val iso3: String,
    @SerializedName("iso2") val iso2: String,
    @SerializedName("states") val states: List<State>
)