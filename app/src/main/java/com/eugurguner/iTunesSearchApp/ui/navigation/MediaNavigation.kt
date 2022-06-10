package com.eugurguner.iTunesSearchApp.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eugurguner.iTunesSearchApp.ui.screens.mediaDetail.MediaDetailScreen
import com.eugurguner.iTunesSearchApp.ui.screens.mediaList.MediaListScreen
import com.eugurguner.iTunesSearchApp.ui.vm.MediaViewModel
import kotlinx.coroutines.FlowPreview

sealed class MediaScreens(val route: String) {
    object MediaListScreen : MediaScreens("media_list_screen")
    object MediaDetailScreen : MediaScreens("media_detail_screen")
}

@FlowPreview
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun MediaNavigation(mediaViewModel: MediaViewModel) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MediaScreens.MediaListScreen.route
    ) {

        composable(
            route = MediaScreens.MediaListScreen.route,
        ) {
            MediaListScreen(navController, mediaViewModel)
        }

        composable(
            route = MediaScreens.MediaDetailScreen.route,
        ) {
            MediaDetailScreen(navController, mediaViewModel)
        }

    }

}