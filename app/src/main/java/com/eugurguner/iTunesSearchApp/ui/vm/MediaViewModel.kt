package com.eugurguner.iTunesSearchApp.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.eugurguner.iTunesSearchApp.data.repository.MediaRepository
import com.eugurguner.iTunesSearchApp.data.repository.paged.MediaSource
import com.eugurguner.iTunesSearchApp.model.EntityType
import com.eugurguner.iTunesSearchApp.model.Media
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@FlowPreview
class MediaViewModel(
    private val mediaRepository: MediaRepository
) : ViewModel() {

    var selectedMedia: Media? = null

    val medias = MutableStateFlow<PagingData<Media>>(PagingData.empty())

    val entityType = MutableStateFlow(EntityType.None)

    val searchText = MutableStateFlow("")

    init {
        viewModelScope.launch {
            searchText.debounce(400)
                .collect {
                    if (it.isNotEmpty() && it.length > 2) searchMedias()
                    else medias.value = PagingData.empty()
                }
        }
    }

    fun searchMedias() {
        viewModelScope.launch {
            Pager(PagingConfig(pageSize = 20, enablePlaceholders = false, prefetchDistance = 3)) {
                MediaSource(mediaRepository, entityType.value, searchText.value)
            }.flow.cachedIn(viewModelScope).collect {
                medias.value = it
            }
        }
    }

    fun updateCategory(category: EntityType) {
        entityType.value = category
        searchMedias()
    }

}