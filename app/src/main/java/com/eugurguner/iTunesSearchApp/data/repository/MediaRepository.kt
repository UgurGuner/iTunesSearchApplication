package com.eugurguner.iTunesSearchApp.data.repository

import com.eugurguner.iTunesSearchApp.data.network.MediaApi

class MediaRepository(private val mediaApi: MediaApi) {

    suspend fun searchMediaList(terms: String, limit: Int, entity: String, offSet: Int) =
        mediaApi.searchMedias(terms, limit, offSet, entity)

}