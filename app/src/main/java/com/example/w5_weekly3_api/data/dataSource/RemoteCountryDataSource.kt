//package com.example.w5_weekly3_api.data.dataSource
//
//import com.example.w5_weekly3_api.api.RetrofitInstance
//import com.example.w5_weekly3_api.data.Country
//
//class RemoteCountryDataSource : CountryDataSource {
//    override suspend fun getCountriesList(): List<Country> {
//        val response = RetrofitInstance.api.getCountries()
//        return if (!response.error) {
//            response.data // Emit the country list
//        } else {
//            emptyList() // Emit empty list on API error
//        }
//    }
//}