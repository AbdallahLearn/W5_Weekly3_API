package com.example.w5_weekly3_api

import CityListScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.w5_weekly3_api.presentation.CountryListScreen
import com.example.w5_weekly3_api.presentation.CountryViewModel
import com.example.w5_weekly3_api.presentation.StateListScreen
import com.example.w5_weekly3_api.ui.theme.W5_Weekly3_APITheme


//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            W5_Weekly3_APITheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Column(){
//                        Text(
//
//                            modifier = Modifier.fillMaxWidth()
//                                .padding(top=10.dp),
//                            text="Country Lists",
//                            fontSize = 30.sp,
//                            textAlign = TextAlign.Center
//                        )
//                        Spacer(modifier = Modifier.height(10.dp))
////                        CountryListScreen()
//                        StateListScreen()
//                    }
//
//                }
//            }
//        }
//    }
//}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            W5_Weekly3_APITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    AppNavigation(navController)
                }
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "countries") {
        composable("countries") {
            CountryListScreen(navController)
        }
        composable("states/{countryName}") { backStackEntry ->
            val countryName = backStackEntry.arguments?.getString("countryName") ?: ""
            StateListScreen(navController, countryName)
        }
        composable("cities/{country}/{state}") { backStackEntry ->
            val country = backStackEntry.arguments?.getString("country") ?: ""
            val state = backStackEntry.arguments?.getString("state") ?: ""
            CityListScreen(navController, country, state)
        }
    }
}