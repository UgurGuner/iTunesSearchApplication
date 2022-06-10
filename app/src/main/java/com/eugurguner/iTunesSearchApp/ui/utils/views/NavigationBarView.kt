package com.eugurguner.iTunesSearchApp.ui.utils.views

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.eugurguner.iTunesSearchApp.ui.theme.ThemeState

@Composable
fun NavigationBarView(
    title: String,
    settingsActionEnabled: Boolean = false,
    backActionEnabled: Boolean = false,
    navController: NavController? = null
) {

    fun onThemeChange() {

        val isDark = ThemeState.darkModeState.value

        val theme = when (isDark) {

            true -> AppCompatDelegate.MODE_NIGHT_NO

            false -> AppCompatDelegate.MODE_NIGHT_YES

        }

        AppCompatDelegate.setDefaultNightMode(theme)

        ThemeState.darkModeState.value = !isDark

    }

    TopAppBar(
        backgroundColor = MaterialTheme.colors.secondary,
        contentColor = MaterialTheme.colors.primaryVariant,
        elevation = 1.dp,
        title = {
            Text(
                text = title,
                textAlign = TextAlign.Start,
                style = TextStyle(
                    background = MaterialTheme.colors.secondary,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                ),
                maxLines = 1,
            )
        },
        navigationIcon = {
            if (backActionEnabled) {
                IconButton(onClick = { navController?.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack, "", tint = MaterialTheme.colors.primaryVariant)
                }
            }
            if (settingsActionEnabled) {
                IconButton(onClick = { onThemeChange() }) {
                    Icon(Icons.Filled.Settings, "", tint = MaterialTheme.colors.primaryVariant)
                }
            }
        },
    )
}

