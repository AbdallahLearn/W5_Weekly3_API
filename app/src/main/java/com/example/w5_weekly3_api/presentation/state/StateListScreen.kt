// presentation/CountryListScreen.kt
package com.example.w5_weekly3_api.presentation

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.w5_weekly3_api.data.State



@Composable
fun StateListScreen(navController: NavController, countryName: String) {
    val viewModel: StateViewModel = viewModel()
    val states by viewModel.states.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    // Fetch states when the screen is launched
    LaunchedEffect(countryName) {
        viewModel.fetchStates(countryName)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Add a title at the top
        Text(
            text = "State Page",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )

        // Show loading indicator if data is being fetched
        if (isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        // Show error message if there's an error
        else if (errorMessage != null) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = errorMessage!!, color = Color.Red)
            }
        }
        // Show the list of states if data is available
        else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(states) { state ->
                    StateItem(state = state, onClick = {
                        // Navigate to cities screen if needed
                    })
                }
            }
        }
    }
}

@Composable
fun StateItem(state: State, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = state.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "Code: ${state.stateCode}", style = MaterialTheme.typography.bodySmall)
        }
    }
}