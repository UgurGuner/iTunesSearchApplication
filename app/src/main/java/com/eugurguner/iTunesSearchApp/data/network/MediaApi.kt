package com.eugurguner.iTunesSearchApp.data.network

import com.eugurguner.iTunesSearchApp.model.MediaListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MediaApi {

    @GET("/search")
    suspend fun searchMedias(
        @Query("term", encoded = true) term: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("entity") entity: String,
    ): MediaListResponse

    @GET("/detail")
    suspend fun mediaDetail(
        @Query("mediaId") mediaId: String,
    ): MediaListResponse

}