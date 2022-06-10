package com.eugurguner.iTunesSearchApp.ui.screens.mediaDetail.infoRow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MediaDetailInfoRowView(title: String, value: String) {
    if (value.isNotEmpty()) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            )

            Text(
                text = value,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End,
                style = TextStyle(
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        }

    }
}