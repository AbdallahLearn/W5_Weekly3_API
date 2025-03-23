// presentation/CountryViewModel.kt
package com.example.w5_weekly3_api.presentation


import StateRequest
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.w5_weekly3_api.api.RetrofitInstance
import com.example.w5_weekly3_api.data.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch



//class StateViewModel : ViewModel() {
//    private val _states = mutableStateOf<List<State>>(emptyList())
//    val states: MutableState<List<State>> = _states
//
//    init {
//        fetchStates()
//    }
//
//    private fun fetchStates() {
//        viewModelScope.launch {
//            try {
//                val response = RetrofitInstance.api.getStates("AF") // Pass country code if needed
//                if (!response.error) {
//                    _states.value = response.data // Assign fetched states
//                } else {
//                    // Handle API error (show error message, log, etc.)
//                }
//            } catch (e: Exception) {
//                // Handle network errors (log or show error message)
//            }
//        }
//    }
//}



class StateViewModel : ViewModel() {
    private val _states = MutableStateFlow<List<State>>(emptyList())
    val states: StateFlow<List<State>> = _states

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun fetchStates(countryName: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                Log.d("StateViewModel", "Fetching states for country: $countryName")
                val request = StateRequest(country = countryName)
                val response = RetrofitInstance.api.getStates(request)
                Log.d("StateViewModel", "API Response: $response")

                if (!response.error) {
                    // Extract the states from the response
                    val states = response.data.states
                    _states.value = states
                } else {
                    _errorMessage.value = "API Error: ${response.msg}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Network Error: ${e.message}"
                Log.e("StateViewModel", "Error fetching states: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }
}