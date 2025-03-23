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

    @GET("countries/{countryCode}/states/{stateCode}/cities")
    suspend fun getCities(
        @Path("countryCode") countryCode: String,
        @Path("stateCode") stateCode: String
    ): ApiResponse<List<City>>
}
//interface ApiService {
//    @GET("states")
//    suspend fun getStates(@Query("country") countryCode: String): ApiResponse<List<State>>  // ✅ Corrected endpoint
//
//    @POST("cities")
//    suspend fun getCities(@Body request: CityRequest): ApiResponse<List<City>>  // ✅ Corrected endpoint
//}

data class StateRequest(
    @SerializedName("country") val country: String
)

data class StateResponse(
    @SerializedName("name") val name: String, // Country name
    @SerializedName("iso2") val iso2: String, // Country code
    @SerializedName("states") val states: List<State> // List of states
)
