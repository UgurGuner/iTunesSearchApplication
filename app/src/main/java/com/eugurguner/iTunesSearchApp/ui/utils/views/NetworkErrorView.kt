package com.eugurguner.iTunesSearchApp.ui.utils.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.eugurguner.iTunesSearchApp.R

@Composable
fun NetworkErrorView(
    onClickRetry: () -> Unit
) {
    Column(
        modifier = Modifier.padding(22.dp),
        verticalArrangement = Arrangement.spacedBy(22.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
        ) {
            AnimationView(resId = R.raw.network_error)
        }
        Box(
            modifier = Modifier
                .border(
                    1.dp,
                    MaterialTheme.colors.primaryVariant,
                    MaterialTheme.shapes.small
                )
                .background(Color.Transparent)
                .clip(MaterialTheme.shapes.small)
                .clickable {
                    onClickRetry()
                }
        ) {
            Text(
                text = "Try Again",
                modifier = Modifier
                    .background(Color.Transparent)
                    .padding(12.dp),
                style = TextStyle(
                    color = MaterialTheme.colors.primaryVariant,
                    background = Color.Transparent
                )
            )
        }
    }
}