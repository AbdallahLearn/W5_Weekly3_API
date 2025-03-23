// presentation/CountryViewModel.kt
package com.example.w5_weekly3_api.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.w5_weekly3_api.data.State
import com.example.w5_weekly3_api.domain.usecase.GetStatesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class StateViewModel(
    private val getStatesUseCase: GetStatesUseCase = GetStatesUseCase()
) : ViewModel() {

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

            getStatesUseCase.execute(countryName).collectLatest { stateList ->
                _states.value = stateList
                _isLoading.value = false
            }
        }
    }
}