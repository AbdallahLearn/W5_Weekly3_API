package com.example.w5_weekly3_api.presentation.city//package com.example.w5_weekly3_api.presentation
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.w5_weekly3_api.data.City
//import com.example.w5_weekly3_api.domain.CountryRepository
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//
//class CityViewModel(private val repository: CountryRepository) : ViewModel() {
//    private val _cities = MutableStateFlow<List<City>>(emptyList())
//    val cities: StateFlow<List<City>> get() = _cities
//
//    fun fetchCities(countryCode: String, stateCode: String) {
//        viewModelScope.launch {
//            _cities.value = repository.getCities(countryCode, stateCode)
//        }
//    }
//}