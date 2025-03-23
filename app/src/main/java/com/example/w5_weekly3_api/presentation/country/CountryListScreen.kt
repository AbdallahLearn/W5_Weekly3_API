// presentation/CountryListScreen.kt
package com.example.w5_weekly3_api.presentation

import android.annotation.SuppressLint
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.w5_weekly3_api.data.Country



@Composable
fun CountryListScreen(
    navController: NavController,
    viewModelStoreOwner: ViewModelStoreOwner = LocalViewModelStoreOwner.current!!
) {
    val viewModel: CountryViewModel = viewModel(viewModelStoreOwner) // Use the provided ViewModelStoreOwner

    val countries by viewModel.countries.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        // Add a title at the top
        Text(
            text = "Country Page",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )

        if (countries.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(countries) { country ->
                    CountryItem(country = country, onClick = {
                        navController.navigate("states/${country.country}") // Pass country name
                    })
                }
            }
        }
    }
}
@Composable
fun CountryItem(country: Country, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {

        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = country.country, style = MaterialTheme.typography.titleMedium)
            Text(text = "ISO2: ${country.iso2}", style = MaterialTheme.typography.bodySmall)
        }
    }
}