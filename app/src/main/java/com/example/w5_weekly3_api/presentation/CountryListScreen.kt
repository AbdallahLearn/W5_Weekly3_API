// presentation/CountryListScreen.kt
package com.example.w5_weekly3_api.presentation

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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.w5_weekly3_api.data.Country

@Composable
fun CountryListScreen(viewModel: CountryViewModel = CountryViewModel()) {
    val countries by viewModel.countries

    if (countries.isEmpty()) {
        // Center the CircularProgressIndicator on the screen
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(48.dp) // Set the size of the CircularProgressIndicator
            )
        }
    } else {
        // Display the list of countries
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(countries) { country ->
                CountryItem(country = country)
            }
        }
    }
}

@Composable
fun CountryItem(country: Country) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = country.country, style = MaterialTheme.typography.titleMedium)
            Text(text = "ISO2: ${country.iso2}", style = MaterialTheme.typography.bodySmall)
            Text(text = "ISO3: ${country.iso3}", style = MaterialTheme.typography.bodySmall)
        }
    }
}
