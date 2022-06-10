package com.eugurguner.iTunesSearchApp

import android.app.Application
import com.eugurguner.iTunesSearchApp.di.networkModule
import com.eugurguner.iTunesSearchApp.di.repositoryModule
import com.eugurguner.iTunesSearchApp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApp)
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }

    }

}