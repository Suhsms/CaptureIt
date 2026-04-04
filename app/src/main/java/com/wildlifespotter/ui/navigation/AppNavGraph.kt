package com.wildlifespotter.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.wildlifespotter.ui.camera.CameraScreen
import com.wildlifespotter.ui.collection.CollectionScreen
import com.wildlifespotter.ui.identification.IdentificationScreen
import com.wildlifespotter.ui.leaderboard.LeaderboardScreen
import com.wildlifespotter.ui.map.SightingsMapScreen

fun NavGraphBuilder.appNavGraph() {
    navigation(startDestination = "camera", route = "app_graph") {
        composable("camera") { CameraScreen() }
        composable("identification") { IdentificationScreen() }
        composable("collection") { CollectionScreen() }
        composable("leaderboard") { LeaderboardScreen() }
        composable("map") { SightingsMapScreen() }
    }
}