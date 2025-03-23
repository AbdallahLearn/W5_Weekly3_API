package com.example.w5_weekly3_api.domain.usecase


import com.example.w5_weekly3_api.api.RetrofitInstance
import com.example.w5_weekly3_api.data.Country
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCountriesUseCase {
    suspend fun execute(): Flow<List<Country>> = flow {
        try {
            val response = RetrofitInstance.api.getCountries()
            if (!response.error) {
                emit(response.data) // Emit the country list
            } else {
                emit(emptyList()) // Emit empty list on API error
            }
        } catch (e: Exception) {
            emit(emptyList()) // Emit empty list on exception
        }
    }
}