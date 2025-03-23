package com.example.w5_weekly3_api.domain.usecase





import android.util.Log
import com.example.w5_weekly3_api.api.RetrofitInstance
import com.example.w5_weekly3_api.data.City
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCitiesUseCase {
    suspend fun execute(country: String, state: String): Flow<List<String>> = flow {
        try {
            Log.d("GetCitiesUseCase", "Fetching cities for country: $country, state: $state")

            val request = City(country = country, state = state)
            val response = RetrofitInstance.api.getCities(request)

            Log.d("GetCitiesUseCase", "API Response: $response")

            if (!response.error) {
                emit(response.data) // Emit list of cities
            } else {
                emit(emptyList()) // Emit empty list if API error occurs
            }
        } catch (e: Exception) {
            Log.e("GetCitiesUseCase", "Error fetching cities: ${e.message}")
            emit(emptyList()) // Emit empty list on network failure
        }
    }
}
