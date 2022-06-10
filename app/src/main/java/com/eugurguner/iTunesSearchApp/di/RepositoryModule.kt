package com.eugurguner.iTunesSearchApp.di

import com.eugurguner.iTunesSearchApp.data.network.MediaApi
import com.eugurguner.iTunesSearchApp.data.repository.MediaRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { createMediaRepository(get()) }
}

fun createMediaRepository(
    mediaApi: MediaApi
): MediaRepository = MediaRepository(mediaApi)
