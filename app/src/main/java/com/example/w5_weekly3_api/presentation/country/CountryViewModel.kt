package com.example.w5_weekly3_api.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.w5_weekly3_api.data.Country
import com.example.w5_weekly3_api.domain.usecase.GetCountriesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CountryViewModel(
    private val getCountriesUseCase: GetCountriesUseCase = GetCountriesUseCase()
) : ViewModel() {

    private val _countries = MutableStateFlow<List<Country>>(emptyList())
    val countries: StateFlow<List<Country>> = _countries

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch {
            _isLoading.value = true
            getCountriesUseCase.execute().collectLatest { countryList ->
                _countries.value = countryList
                _isLoading.value = false
            }
        }
    }
}
