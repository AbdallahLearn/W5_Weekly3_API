
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.w5_weekly3_api.domain.usecase.GetCitiesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CityViewModel(private val getCitiesUseCase: GetCitiesUseCase) : ViewModel() {
    private val _cities = MutableStateFlow<List<String>>(emptyList())
    val cities: StateFlow<List<String>> = _cities

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun fetchCities(country: String, state: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            getCitiesUseCase.execute(country, state).collect { cityList ->
                _cities.value = cityList
                _isLoading.value = false
            }
        }
    }
}