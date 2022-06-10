package com.eugurguner.iTunesSearchApp.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.eugurguner.iTunesSearchApp.ui.navigation.MediaNavigation
import com.eugurguner.iTunesSearchApp.ui.vm.MediaViewModel
import com.eugurguner.iTunesSearchApp.ui.theme.AppTheme
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    @OptIn(FlowPreview::class)
    private val mediaViewModel: MediaViewModel by viewModel()

    @OptIn(ExperimentalComposeUiApi::class, FlowPreview::class, ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()

        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                MediaNavigation(mediaViewModel)
            }
        }

    }

}