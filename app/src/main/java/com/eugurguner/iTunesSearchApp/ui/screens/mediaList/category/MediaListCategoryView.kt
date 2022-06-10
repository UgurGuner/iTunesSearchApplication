package com.eugurguner.iTunesSearchApp.ui.screens.mediaList.category

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eugurguner.iTunesSearchApp.model.EntityType
import com.eugurguner.iTunesSearchApp.ui.vm.MediaViewModel
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalComposeUiApi
@Composable
fun MediaListCategoryView(mediaViewModel: MediaViewModel) {

    Column(verticalArrangement = Arrangement.spacedBy(22.dp)) {

        Text(
            text = "Choose Category",
            style = TextStyle(
                MaterialTheme.colors.primaryVariant,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            MediaListCategoryItemView(
                title = "Movies",
                entityType = EntityType.Movies,
                modifier = Modifier.weight(1f),
                mediaViewModel = mediaViewModel,
                onSelectEntityType = { mediaViewModel.updateCategory(it) })
            MediaListCategoryItemView(
                title = "Music",
                entityType = EntityType.Music,
                modifier = Modifier.weight(1f),
                mediaViewModel = mediaViewModel,
                onSelectEntityType = { mediaViewModel.updateCategory(it) })
            MediaListCategoryItemView(
                title = "Apps",
                entityType = EntityType.Apps,
                modifier = Modifier.weight(1f),
                mediaViewModel = mediaViewModel,
                onSelectEntityType = { mediaViewModel.updateCategory(it) })
            MediaListCategoryItemView(
                title = "Books",
                entityType = EntityType.Books,
                modifier = Modifier.weight(1f),
                mediaViewModel = mediaViewModel,
                onSelectEntityType = { mediaViewModel.updateCategory(it) })

        }

    }

}