package com.eugurguner.iTunesSearchApp.ui.utils.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun AnimationView(resId: Int) {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(resId))

    LottieAnimation(
        composition,
        iterations = LottieConstants.IterateForever
    )

}