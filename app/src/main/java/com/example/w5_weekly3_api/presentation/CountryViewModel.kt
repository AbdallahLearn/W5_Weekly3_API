// presentation/CountryViewModel.kt
package com.example.w5_weekly3_api.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.w5_weekly3_api.api.RetrofitInstance
import com.example.w5_weekly3_api.data.Country
import kotlinx.coroutines.launch

class CountryViewModel : ViewModel() {
    private val _countries = mutableStateOf<List<Country>>(emptyList())
    val countries: State<List<Country>> = _countries

    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getCountries()
                if (!response.error) {
                    _countries.value = response.data // Extract the list of countries
                } else {
                    // Handle API error
                }
            } catch (e: Exception) {
                // Handle network errors
            }
        }
    }
}