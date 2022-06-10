package com.eugurguner.iTunesSearchApp.ui.screens.mediaList.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.vponomarenko.compose.shimmer.shimmer

@Composable
fun MediaListItemLoadingView() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .shimmer(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Box(
            modifier = Modifier
                .height(140.dp)
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium)
                .background(Color.LightGray)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(Color.LightGray)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(Color.LightGray)
        )

    }
}