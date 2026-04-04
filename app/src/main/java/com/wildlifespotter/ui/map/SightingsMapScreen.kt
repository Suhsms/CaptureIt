package com.wildlifespotter.ui.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.wildlifespotter.ui.map.SightingsMapViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SightingsMapScreen(
    viewModel: SightingsMapViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        // Map UI goes here, using viewModel to get sightings data
    }
}