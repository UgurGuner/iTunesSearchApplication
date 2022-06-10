package com.eugurguner.iTunesSearchApp.di

import com.eugurguner.iTunesSearchApp.ui.vm.MediaViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MediaViewModel(get()) }
}