package com.eugurguner.iTunesSearchApp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

object ThemeState {
    var darkModeState: MutableState<Boolean> = mutableStateOf(false)
}

@Composable
fun AppTheme(
    darkTheme: Boolean = !isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        shapes = Shapes,
        content = content
    )

}
