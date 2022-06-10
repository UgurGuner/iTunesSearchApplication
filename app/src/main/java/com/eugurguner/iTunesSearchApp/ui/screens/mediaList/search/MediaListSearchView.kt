package com.eugurguner.iTunesSearchApp.ui.screens.mediaList.search

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eugurguner.iTunesSearchApp.ui.vm.MediaViewModel
import kotlinx.coroutines.FlowPreview

@FlowPreview
@SuppressLint("FlowOperatorInvokedInComposition")
@Composable
fun MediaListSearchView(
    mediaViewModel: MediaViewModel
) {

    val searchText by mediaViewModel.searchText.collectAsState()

    val focusManager = LocalFocusManager.current

    BasicTextField(
        value = searchText,
        onValueChange = {
            mediaViewModel.searchText.value = it
        },
        maxLines = 1,
        textStyle = TextStyle(MaterialTheme.colors.primary, fontSize = 14.sp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        keyboardActions = KeyboardActions(onDone = {
            focusManager.clearFocus()
        }),
        decorationBox = { innerTextField ->
            Box(
                Modifier
                    .background(
                        MaterialTheme.colors.primaryVariant,
                        RoundedCornerShape(percent = 50)
                    )
                    .fillMaxWidth()
                    .padding(8.dp),
                contentAlignment = Alignment.CenterStart
            ) {

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(Icons.Filled.Search, "", tint = MaterialTheme.colors.secondary)

                    Row(modifier = Modifier.fillMaxWidth()) {

                        Box(Modifier.weight(1f)) {

                            if (searchText.isEmpty()) {

                                Text(
                                    "Search...",
                                    style = TextStyle(
                                        MaterialTheme.colors.primary,
                                        fontSize = 14.sp
                                    )
                                )

                            }

                            innerTextField()

                        }

                        if (searchText.isNotEmpty())
                            Icon(
                                Icons.Filled.Close,
                                "",
                                tint = MaterialTheme.colors.secondary,
                                modifier = Modifier
                                    .weight(1f)
                                    .clickable {
                                        focusManager.clearFocus()
                                        mediaViewModel.searchText.value = ""
                                    })

                    }

                }

            }
        },
    )

}