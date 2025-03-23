package com.example.w5_weekly3_api.data.dataSource

import com.example.w5_weekly3_api.data.Country
import com.example.w5_weekly3_api.data.State
import com.example.w5_weekly3_api.data.City

interface CountryDataSource {
    // Fetch list of countries
    suspend fun getCountriesList(): List<Country>

    // Fetch list of states for a given country
    suspend fun getStatesList(countryName: String): List<State>

    // Fetch list of cities for a given country and state
    suspend fun getCitiesList(countryName: String, stateName: String): List<City>
}