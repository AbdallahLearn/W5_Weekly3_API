package com.example.w5_weekly3_api.api

import com.example.w5_weekly3_api.data.Country
import retrofit2.http.GET



interface ApiService {
    @GET("countries")
    suspend fun getCountries(): ApiResponse
}