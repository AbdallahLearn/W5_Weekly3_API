package com.example.w5_weekly3_api.data.dataSource

import StateRequest
import com.example.w5_weekly3_api.api.RetrofitInstance
import com.example.w5_weekly3_api.data.City
import com.example.w5_weekly3_api.data.Country
import com.example.w5_weekly3_api.data.State

class RemoteCountryDataSource : CountryDataSource {
    override suspend fun getCountriesList(): List<Country> {
        val response = RetrofitInstance.api.getCountries()
        return if (!response.error) {
            response.data // Emit the country list
        } else {
            emptyList() // Emit empty list on API error
        }
    }

    override suspend fun getStatesList(countryName: String): List<State> {
        return try {
            // Create the request body
            val request = StateRequest(country = countryName)

            // Call the API
            val response = RetrofitInstance.api.getStates(request)

            // Check for errors and return the list of states
            if (!response.error) {
                response.data.states // Return the list of states
            } else {
                emptyList() // Return empty list on API error
            }
        } catch (e: Exception) {
            // Handle network or other exceptions
            emptyList() // Return empty list on failure
        }
    }

    override suspend fun getCitiesList(countryName: String, stateName: String): List<City> {
        return try {
            // Create the request body
            val request = City(country = countryName, state = stateName)

            // Call the API
            val response = RetrofitInstance.api.getCities(request)

            // Check for errors and return the list of cities
            if (!response.error) {
                response.data.map { City(
                    it,
                    state = TODO()
                ) } // Convert list of city names to City objects
            } else {
                emptyList() // Return empty list on API error
            }
        } catch (e: Exception) {
            // Handle network or other exceptions
            emptyList() // Return empty list on failure
        }
    }
}