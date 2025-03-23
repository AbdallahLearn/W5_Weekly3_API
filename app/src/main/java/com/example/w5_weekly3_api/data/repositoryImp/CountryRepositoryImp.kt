//package com.example.w5_weekly3_api.data.repositoryImp
//
//import com.example.w5_weekly3_api.data.Country
//import com.example.w5_weekly3_api.data.dataSource.CountryDataSource
//import com.example.w5_weekly3_api.domain.repository.CountryRepository
//
//class CountryRepositoryImp(
//    private val remoteCountryDataSource: CountryDataSource,
//    private val localCountryDataSource: CountryDataSource,
//) :
//    CountryRepository {
//    override suspend fun getCountriesList(): List<Country> {
//        return remoteCountryDataSource.getCountriesList()
//    }
//}