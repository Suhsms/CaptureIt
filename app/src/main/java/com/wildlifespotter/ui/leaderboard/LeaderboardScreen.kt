package com.wildlifespotter.ui.leaderboard

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wildlifespotter.domain.model.User

@Composable
fun LeaderboardScreen(
    viewModel: LeaderboardViewModel = viewModel()
) {
    val leaderboardState = viewModel.leaderboardState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Leaderboard") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (leaderboardState.value) {
                is LeaderboardState.Loading -> {
                    CircularProgressIndicator()
                }
                is LeaderboardState.Success -> {
                    val users = (leaderboardState.value as LeaderboardState.Success).users
                    UserList(users)
                }
                is LeaderboardState.Error -> {
                    Text("Error loading leaderboard")
                }
            }
        }
    }
}

@Composable
fun UserList(users: List<User>) {
    Column {
        users.forEach { user ->
            Text("${user.name}: ${user.points} points")
        }
    }
}