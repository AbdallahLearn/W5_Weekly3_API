package com.example.w5_weekly3_api


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.navigation.compose.rememberNavController
import com.example.w5_weekly3_api.navigation.AppNavigation

import com.example.w5_weekly3_api.ui.theme.W5_Weekly3_APITheme




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // State to track dark mode
            var darkTheme by remember { mutableStateOf(false) }

            // Apply the theme based on the state
            W5_Weekly3_APITheme(darkTheme = darkTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        // Dark Mode Toggle Switch
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = if (darkTheme) "Dark Mode" else "Light Mode",
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Switch(
                                checked = darkTheme,
                                onCheckedChange = { darkTheme = it }
                            )
                        }

                        // Navigation
                        val navController = rememberNavController()
                        AppNavigation(navController)
                    }
                }
            }
        }
    }
}