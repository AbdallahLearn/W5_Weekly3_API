package com.example.w5_weekly3_api.data

data class Country(
    val iso2: String,
    val iso3: String,
    val country: String, // Renamed from "name" to "country" to match the API
    val cities: List<String>
)