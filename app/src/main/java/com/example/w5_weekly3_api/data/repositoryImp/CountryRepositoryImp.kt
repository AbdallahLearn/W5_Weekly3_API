package com.example.w5_weekly3_api.data.repositoryImpl

import com.example.w5_weekly3_api.data.dataSource.CountryDataSource
import com.example.w5_weekly3_api.domain.repository.CountryRepository
import com.example.w5_weekly3_api.data.Country
import com.example.w5_weekly3_api.data.State
import com.example.w5_weekly3_api.data.City

class CountryRepositoryImpl(
    private val remoteCountryDataSource: CountryDataSource
) : CountryRepository {

    override suspend fun getCountriesList(): List<Country> {
        return remoteCountryDataSource.getCountriesList()
    }

    override suspend fun getStatesList(countryName: String): List<State> {
        return remoteCountryDataSource.getStatesList(countryName)
    }

    override suspend fun getCitiesList(countryName: String, stateName: String): List<City> {
        return remoteCountryDataSource.getCitiesList(countryName, stateName)
    }
}