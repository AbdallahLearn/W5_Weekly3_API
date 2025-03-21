package com.example.w5_weekly3_api.api

import com.example.w5_weekly3_api.data.Country

data class ApiResponse(
    val error: Boolean,
    val msg: String,
    val data: List<Country> // List of countries
)