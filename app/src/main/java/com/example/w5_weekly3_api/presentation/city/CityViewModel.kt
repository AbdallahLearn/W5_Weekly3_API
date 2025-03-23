import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.w5_weekly3_api.api.RetrofitInstance
import com.example.w5_weekly3_api.data.City
import com.example.w5_weekly3_api.data.CityRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class CityViewModel : ViewModel() {
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

            try {
                Log.d("CityViewModel", "Fetching cities for country: $country, state: $state")
                val request = CityRequest(country = country, state = state)
                val response = RetrofitInstance.api.getCities(request)
                Log.d("CityViewModel", "API Response: $response")

                if (!response.error) {
                    _cities.value = response.data
                } else {
                    _errorMessage.value = "API Error: ${response.msg}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Network Error: ${e.message}"
                Log.e("CityViewModel", "Error fetching cities: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }
}