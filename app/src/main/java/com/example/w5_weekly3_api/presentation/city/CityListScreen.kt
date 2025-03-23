package com.example.w5_weekly3_api.presentation.city//package com.example.w5_weekly3_api.presentation
//
//
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.Card
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import com.example.w5_weekly3_api.data.City
//
//@Composable
//fun CityListScreen(viewModel: CityViewModel) {
//    val cities by viewModel.cities.collectAsState()
//
//    if (cities.isEmpty()) {
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            CircularProgressIndicator(modifier = Modifier.size(48.dp))
//        }
//    } else {
//        LazyColumn(modifier = Modifier.fillMaxSize()) {
//            items(cities) { city ->
//                CityItem(city = city)
//            }
//        }
//    }
//}
//
//@Composable
//fun CityItem(city: City) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//    ) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Text(text = city.name, style = MaterialTheme.typography.titleMedium)
//        }
//    }
//}