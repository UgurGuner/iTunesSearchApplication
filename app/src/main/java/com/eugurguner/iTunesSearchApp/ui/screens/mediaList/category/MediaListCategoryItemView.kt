package com.eugurguner.iTunesSearchApp.ui.screens.mediaList.category

import android.annotation.SuppressLint
import android.view.MotionEvent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eugurguner.iTunesSearchApp.model.EntityType
import com.eugurguner.iTunesSearchApp.ui.vm.MediaViewModel
import kotlinx.coroutines.FlowPreview

@FlowPreview
@SuppressLint("StateFlowValueCalledInComposition")
@ExperimentalComposeUiApi
@Composable
fun MediaListCategoryItemView(
    title: String,
    mediaViewModel: MediaViewModel,
    entityType: EntityType,
    modifier: Modifier,
    onSelectEntityType: (value: EntityType) -> Unit
) {

    val focusManager = LocalFocusManager.current

    val selectedEntityType = mediaViewModel.entityType.collectAsState()

    val selected = remember { mutableStateOf(false) }

    val scale = animateFloatAsState(if (selected.value) 1.2f else 1f)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .scale(scale.value)
            .border(1.dp, MaterialTheme.colors.primaryVariant, MaterialTheme.shapes.medium)
            .height(30.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(
                color = if (selectedEntityType.value == entityType) MaterialTheme.colors.primaryVariant else MaterialTheme.colors.primary
            )
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        selected.value = true
                    }
                    MotionEvent.ACTION_UP -> {
                        selected.value = false
                        focusManager.clearFocus()
                        onSelectEntityType(if (selectedEntityType.value == entityType) EntityType.None else entityType)
                    }
                }
                true
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            title,
            modifier = Modifier.padding(bottom = 2.dp),
            style = TextStyle(
                fontSize = 12.sp,
                fontStyle = FontStyle.Normal,
                color = if (selectedEntityType.value == entityType) MaterialTheme.colors.primary else MaterialTheme.colors.primaryVariant,
                fontWeight = if (selectedEntityType.value == entityType) FontWeight.Bold else FontWeight.Medium
            )
        )
    }

}