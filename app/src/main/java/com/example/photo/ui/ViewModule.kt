package com.example.photo.ui

import com.example.photo.ui.photos.detail.DetailPhotoViewModel
import com.example.photo.ui.photos.list.PhotosViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModule = module {

    viewModel { PhotosViewModel(androidApplication()) }

    //viewModel { CreatePhotoViewModel(androidApplication()) }

    viewModel { DetailPhotoViewModel(androidApplication()) }

}