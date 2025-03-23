import com.example.w5_weekly3_api.api.ApiResponse
import com.example.w5_weekly3_api.data.City
import com.example.w5_weekly3_api.data.Country
import com.example.w5_weekly3_api.data.CountryWithStates
import com.example.w5_weekly3_api.data.State
import com.google.gson.annotations.SerializedName
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface ApiService {
    @GET("countries")
    suspend fun getCountries(): ApiResponse<List<Country>>

    @POST("countries/states")
    suspend fun getStates(@Body request: StateRequest): ApiResponse<CountryWithStates>

    @POST("countries/state/cities")
    suspend fun getCities(@Body request: City): ApiResponse<List<String>>
}

data class StateRequest(
    @SerializedName("country") val country: String
)

