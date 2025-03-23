// presentation/CountryViewModel.kt
package com.example.w5_weekly3_api.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.w5_weekly3_api.api.RetrofitInstance
import com.example.w5_weekly3_api.data.Country
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch



class CountryViewModel : ViewModel() {
    private val _countries = MutableStateFlow<List<Country>>(emptyList())
    val countries: StateFlow<List<Country>> = _countries

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val response = RetrofitInstance.api.getCountries()
                if (!response.error) {
                    _countries.value = response.data // Extract the list of countries
                } else {
                    // Handle API error
                }
            } catch (e: Exception) {
                // Handle network errors
            } finally {
                _isLoading.value = false
            }
        }
    }
}