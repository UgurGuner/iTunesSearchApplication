package com.eugurguner.iTunesSearchApp.data.repository.paged

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.eugurguner.iTunesSearchApp.data.repository.MediaRepository
import com.eugurguner.iTunesSearchApp.model.EntityType
import com.eugurguner.iTunesSearchApp.model.Media

class MediaSource(
    private val mediaRepository: MediaRepository,
    private val entityType: EntityType,
    private val searchKey: String
) : PagingSource<Int, Media>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Media> {

        try {

            val nextPage = params.key ?: 1

            val response = mediaRepository.searchMediaList(
                searchKey,
                20,
                entityType.value,
                if (nextPage == 0) 1 else nextPage * 25
            )

            return LoadResult.Page(
                data = response.results,
                prevKey =
                if (nextPage == 1) null
                else nextPage - 1,
                nextKey = if (response.results.isEmpty() || response.results.size < 20) null else nextPage.plus(
                    1
                )
            )

        } catch (ex: Throwable) {

            return LoadResult.Error(
                Exception()
            )

        }

    }

    override fun getRefreshKey(state: PagingState<Int, Media>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }
}