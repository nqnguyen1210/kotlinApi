package com.example.photo.data

import androidx.room.Room
import com.example.photo.data.local.PhotoDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val dataModule = module {

    single { Room.databaseBuilder(androidApplication(), PhotoDatabase::class.java, PhotoDatabase.DATABASE_NAME).build() }

    single { get<PhotoDatabase>().photoDao() }

    single { PhotoRepository() }

}