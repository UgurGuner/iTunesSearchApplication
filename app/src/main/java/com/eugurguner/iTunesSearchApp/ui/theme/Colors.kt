package com.eugurguner.iTunesSearchApp.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val whiteIsh = Color(0xFFEFEFEF)
val black = Color.Black
val white = Color.White
val grey = Color.LightGray
val darkGrey = Color.DarkGray

val DarkColorPalette = darkColors(
    primary = black,
    primaryVariant = white,
    secondary = black,
    secondaryVariant = grey
)

val LightColorPalette = lightColors(
    primary = white,
    primaryVariant = black,
    secondary = whiteIsh,
    secondaryVariant = darkGrey
)