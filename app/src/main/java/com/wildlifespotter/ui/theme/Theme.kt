package com.wildlifespotter.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF4CAF50),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFC8E6C9),
    onPrimaryContainer = Color(0xFF1B5E20),
    secondary = Color(0xFF03DAC6),
    onSecondary = Color.Black,
    secondaryContainer = Color(0xFFB2EBE7),
    onSecondaryContainer = Color(0xFF004D40),
    background = Color(0xFFF0F0F0),
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    error = Color(0xFFB3261E),
    onError = Color.White,
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF81C784),
    onPrimary = Color(0xFF1B5E20),
    primaryContainer = Color(0xFF2E7D32),
    onPrimaryContainer = Color(0xFFC8E6C9),
    secondary = Color(0xFF4DB8AC),
    onSecondary = Color(0xFF00332E),
    secondaryContainer = Color(0xFF004D40),
    onSecondaryContainer = Color(0xFFB2EBE7),
    background = Color(0xFF121212),
    onBackground = Color.White,
    surface = Color(0xFF1F1F1F),
    onSurface = Color.White,
    error = Color(0xFFF9DEDC),
    onError = Color(0xFF5F1F1B),
)

@Composable
fun WildlifeSpotterTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}