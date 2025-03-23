package com.example.w5_weekly3_api.domain.repository

import com.example.w5_weekly3_api.data.City
import com.example.w5_weekly3_api.data.Country
import com.example.w5_weekly3_api.data.State

interface CountryRepository {

    suspend fun getCountriesList(): List<Country>
    suspend fun getStatesList(countryName: String): List<State>
    suspend fun getCitiesList(countryName: String, stateName: String): List<City>
}