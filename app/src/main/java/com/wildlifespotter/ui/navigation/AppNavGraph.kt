package com.wildlifespotter.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.wildlifespotter.ui.camera.CameraScreen

fun NavGraphBuilder.appNavGraph() {
    navigation(startDestination = "camera", route = "app_graph") {
        composable("camera") { CameraScreen() }
    }
}