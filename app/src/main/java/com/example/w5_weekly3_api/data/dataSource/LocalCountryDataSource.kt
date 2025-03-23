package com.example.w5_weekly3_api.data.dataSource

import StateRequest
import com.example.w5_weekly3_api.api.RetrofitInstance
import com.example.w5_weekly3_api.data.City
import com.example.w5_weekly3_api.data.Country
import com.example.w5_weekly3_api.data.State
import java.io.IOException

class LocalCountryDataSource : CountryDataSource {
    // Fetch list of countries
    override suspend fun getCountriesList(): List<Country> {
        return try {
            val response = RetrofitInstance.api.getCountries()
            if (!response.error) {
                response.data // Return the list of countries
            } else {
                emptyList() // Return empty list on API error
            }
        } catch (e: IOException) {
            emptyList() // Handle network errors
        }
    }

    // Fetch list of states for a given country
    override suspend fun getStatesList(countryName: String): List<State> {
        return try {
            val request = StateRequest(country = countryName)
            val response = RetrofitInstance.api.getStates(request)
            if (!response.error) {
                response.data.states // Return the list of states
            } else {
                emptyList() // Return empty list on API error
            }
        } catch (e: IOException) {
            emptyList() // Handle network errors
        }
    }

    // Fetch list of cities for a given country and state
    override suspend fun getCitiesList(countryName: String, stateName: String): List<City> {
        return try {
            val request = City(country = countryName, state = stateName)
            val response = RetrofitInstance.api.getCities(request)
            if (!response.error) {
                response.data.map { City(
                    it,
                    state = TODO()
                ) } // Convert list of city names to City objects
            } else {
                emptyList() // Return empty list on API error
            }
        } catch (e: IOException) {
            emptyList() // Handle network errors
        }
    }
}