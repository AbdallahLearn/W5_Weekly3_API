//package com.example.w5_weekly3_api.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import com.example.w5_weekly3_api.presentation.CountryListScreen
//
//
//@Composable
//fun AppNavigation(navController: NavHostController) {
//    NavHost(
//        navController = navController,
//        startDestination = "country_list" // Ensure this matches your route
//    ) {
//        composable("country_list") {
//            CountryListScreen(navController = navController) // Pass navController
//        }
//        composable("state_list/{countryCode}") { backStackEntry ->
//            val countryCode = backStackEntry.arguments?.getString("countryCode")
//            val stateViewModel: StateViewModel = viewModel(
//                factory = StateViewModelFactory(countryCode ?: "")
//            )
//            StateListScreen(viewModel = stateViewModel, navController = navController)
//        }
//        // Add other composable routes as needed
//    }
//}
