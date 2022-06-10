package com.eugurguner.iTunesSearchApp.ui.screens.mediaList.list

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.eugurguner.iTunesSearchApp.model.Media

@Composable
fun MediaListItemView(media: Media, modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp),
        verticalAlignment = Alignment.Top,
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SubcomposeAsyncImage(
                model = media.artworkUrl100 ?: "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(140.dp)
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.medium),
                contentDescription = ""
            ) {
                SubcomposeAsyncImageContent()
                if (media.getCollectionPrice().isNotEmpty()) {
                    Box {
                        Surface(color = MaterialTheme.colors.primaryVariant) {
                            Text(
                                text = "${media.collectionPrice ?: ""}$",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Black,
                                color = MaterialTheme.colors.primary,
                                modifier = Modifier
                                    .padding(start = 8.dp, end = 8.dp)
                            )
                        }
                    }
                }
            }
            Text(
                text = media.collectionName ?: media.trackName ?: "",
                textAlign = TextAlign.Center,
                maxLines = 2,
                style = TextStyle(
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                ),
            )
            Text(
                text = media.formatReleaseDate(),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = MaterialTheme.colors.secondaryVariant,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium
                )
            )
        }

    }
}