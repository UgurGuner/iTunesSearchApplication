package com.eugurguner.iTunesSearchApp.di

import com.eugurguner.iTunesSearchApp.data.network.MediaApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.koin.dsl.module

val networkModule = module {
    single { okhttpClient() }
    single { retrofit() }
    single { apiService(get()) }
}

fun apiService(
    retrofit: Retrofit
): MediaApi =
    retrofit.create(MediaApi::class.java)

fun retrofit(
): Retrofit =
    Retrofit.Builder()
        .baseUrl("https://itunes.apple.com/") // build gradle'a gecicek
        .addConverterFactory(GsonConverterFactory.create())
        .build()

fun okhttpClient(
): OkHttpClient? =
    try {
        OkHttpClient.Builder()
            .build()
    } catch (ex: Throwable) {
        null
    }