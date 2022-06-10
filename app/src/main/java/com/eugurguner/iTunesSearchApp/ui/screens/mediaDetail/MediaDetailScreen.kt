package com.eugurguner.iTunesSearchApp.ui.screens.mediaDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.eugurguner.iTunesSearchApp.ui.screens.mediaDetail.infoRow.MediaDetailInfoRowView
import com.eugurguner.iTunesSearchApp.ui.utils.views.NavigationBarView
import com.eugurguner.iTunesSearchApp.ui.vm.MediaViewModel
import kotlinx.coroutines.FlowPreview

@FlowPreview
@Composable
fun MediaDetailScreen(navController: NavController, mediaViewModel: MediaViewModel) {

    val media = mediaViewModel.selectedMedia ?: return

    Scaffold(topBar = {
        NavigationBarView(
            title = media.getFilledTitle(),
            backActionEnabled = true,
            navController = navController
        )
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

                SubcomposeAsyncImage(
                    model = media.artworkUrl100 ?: "",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .height(250.dp)
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

                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.Start
                ) {

                    MediaDetailInfoRowView("Release Date:", media.formatReleaseDate())
                    MediaDetailInfoRowView("Collection Name:", media.collectionName ?: "")
                    MediaDetailInfoRowView("Track Name:", media.trackName ?: "")
                    MediaDetailInfoRowView("Track Count:", media.trackCount?.toString() ?: "")
                    MediaDetailInfoRowView("Track Number:", media.trackNumber?.toString() ?: "")
                    MediaDetailInfoRowView("Artist Name:", media.artistName ?: "")
                    MediaDetailInfoRowView("Collection Price:", media.getCollectionPrice())
                    MediaDetailInfoRowView("Track Price:", media.getTrackPrice())
                    MediaDetailInfoRowView("Price:", media.getPrice())

                }

            }

        }

    }

}