package com.eugurguner.iTunesSearchApp.ui.screens.mediaList

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.eugurguner.iTunesSearchApp.ui.navigation.MediaScreens
import com.eugurguner.iTunesSearchApp.ui.screens.mediaList.category.MediaListCategoryView
import com.eugurguner.iTunesSearchApp.ui.screens.mediaList.list.MediaListView
import com.eugurguner.iTunesSearchApp.ui.screens.mediaList.search.MediaListSearchView
import com.eugurguner.iTunesSearchApp.ui.utils.views.NavigationBarView
import com.eugurguner.iTunesSearchApp.ui.vm.MediaViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.FlowPreview

@ExperimentalFoundationApi
@FlowPreview
@ExperimentalComposeUiApi
@Composable
fun MediaListScreen(
    navController: NavController,
    mediaViewModel: MediaViewModel
) {

    Scaffold(topBar = {
        NavigationBarView(
            title = "iTunesSearch Media List",
            settingsActionEnabled = true
        )
    }) {

        SwipeRefresh(
            state = rememberSwipeRefreshState(false),
            onRefresh = {
                mediaViewModel.searchMedias()
            }) {

            Column(
                modifier = Modifier
                    .background(MaterialTheme.colors.secondary)
                    .fillMaxSize()
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 22.dp, start = 22.dp, end = 22.dp),
                    verticalArrangement = Arrangement.spacedBy(42.dp)
                ) {
                    MediaListSearchView(mediaViewModel)
                    MediaListCategoryView(mediaViewModel)
                    MediaListView(mediaViewModel) {
                        mediaViewModel.selectedMedia = it
                        navController.navigate(MediaScreens.MediaDetailScreen.route)
                    }
                }

            }

        }
    }

}