package com.example.w5_weekly3_api.domain.usecase


import StateRequest
import android.util.Log
import com.example.w5_weekly3_api.api.RetrofitInstance
import com.example.w5_weekly3_api.data.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetStatesUseCase {
    suspend fun execute(countryName: String): Flow<List<State>> = flow {
        try {
            Log.d("GetStatesUseCase", "Fetching states for country: $countryName")

            val request = StateRequest(country = countryName) // ✅ Correct: Wrap countryName in StateRequest
            val response = RetrofitInstance.api.getStates(request)

            Log.d("GetStatesUseCase", "API Response: $response")

            if (!response.error) {
                emit(response.data.states) // Emit the list of states
            } else {
                emit(emptyList()) // Emit empty list on API error
            }
        } catch (e: Exception) {
            Log.e("GetStatesUseCase", "Error fetching states: ${e.message}")
            emit(emptyList()) // Emit empty list on network failure
        }
    }
}