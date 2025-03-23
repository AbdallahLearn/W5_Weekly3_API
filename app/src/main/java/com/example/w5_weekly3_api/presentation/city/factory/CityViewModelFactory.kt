package com.example.w5_weekly3_api.presentation.city.factory

import CityViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.w5_weekly3_api.domain.usecase.GetCitiesUseCase

class CityViewModelFactory(private val getCitiesUseCase: GetCitiesUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CityViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CityViewModel(getCitiesUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
