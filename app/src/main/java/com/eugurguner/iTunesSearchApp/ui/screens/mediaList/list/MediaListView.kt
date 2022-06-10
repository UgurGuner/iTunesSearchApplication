package com.eugurguner.iTunesSearchApp.ui.screens.mediaList.list

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.eugurguner.iTunesSearchApp.R
import com.eugurguner.iTunesSearchApp.model.Media
import com.eugurguner.iTunesSearchApp.ui.vm.MediaViewModel
import com.eugurguner.iTunesSearchApp.ui.utils.items
import com.eugurguner.iTunesSearchApp.ui.utils.views.NetworkErrorView
import com.eugurguner.iTunesSearchApp.ui.utils.views.AnimationView
import kotlinx.coroutines.FlowPreview

@FlowPreview
@SuppressLint("StateFlowValueCalledInComposition")
@ExperimentalFoundationApi
@Composable
fun MediaListView(mediaViewModel: MediaViewModel, onClickItem: (media: Media) -> Unit) {

    val searchText by mediaViewModel.searchText.collectAsState()

    val lazyMediaItems = mediaViewModel.medias.collectAsLazyPagingItems()

    if (searchText.length < 3) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 22.dp, end = 22.dp),
            verticalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            AnimationView(resId = R.raw.empty_search)
            Text(
                text = "Let's search for something..",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                )
            )
        }

    } else {

        LazyVerticalGrid(cells = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(22.dp),
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier.fillMaxHeight(),
            state = rememberLazyListState(),
            content = {

                lazyMediaItems.apply {
                    when {
                        lazyMediaItems.loadState.refresh is LoadState.Loading -> {
                            items(20) {
                                MediaListItemLoadingView()
                            }
                        }

                        lazyMediaItems.loadState.refresh is LoadState.Error || lazyMediaItems.loadState.append is LoadState.Error -> {
                            item(span = { GridItemSpan(currentLineSpan = maxCurrentLineSpan) }) {
                                Box(modifier = Modifier.fillMaxWidth()) {
                                    NetworkErrorView(
                                        onClickRetry = { retry() }
                                    )
                                }
                            }
                        }

                        else -> {

                            if (lazyMediaItems.itemSnapshotList.isEmpty()) {

                                item(span = { GridItemSpan(currentLineSpan = maxCurrentLineSpan) }) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 22.dp, end = 22.dp),
                                        verticalArrangement = Arrangement.spacedBy(22.dp)
                                    ) {
                                        AnimationView(resId = R.raw.empty_search)
                                        Text(
                                            text = "Sorry, we couldn't find any results for $searchText.",
                                            textAlign = TextAlign.Center,
                                            style = TextStyle(
                                                color = MaterialTheme.colors.primaryVariant,
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Medium
                                            )
                                        )
                                    }
                                }

                            } else {

                                items(lazyMediaItems) { media ->
                                    MediaListItemView(media = media!!, Modifier.clickable {
                                        onClickItem(media)
                                    })
                                }

                                if (lazyMediaItems.loadState.append is LoadState.Loading) {
                                    item {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .size(100.dp),
                                        ) {
                                            AnimationView(resId = R.raw.pagination)
                                        }
                                    }
                                }

                            }

                        }
                    }
                }

            })

    }

}