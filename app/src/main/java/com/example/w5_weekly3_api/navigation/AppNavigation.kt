// navigation/AppNavigation.kt
package com.example.w5_weekly3_api.navigation

import CityListScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.w5_weekly3_api.presentation.CountryListScreen
import com.example.w5_weekly3_api.presentation.StateListScreen


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