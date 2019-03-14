package com.example.photo

import android.app.Application
import org.koin.android.ext.android.startKoin

class MainActivity : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, appModule)

        /*
        PhotoRepository.initialize(this)

        val photos = listOf(
            Photo(
                albumId = 1,
                id = 1,
                title = "Photo title 1",
                url = "https://via.placeholder.com/600/66b7d2"
            ),

            Photo(
                albumId = 1,
                id = 2,
                title = "Photo title 2",
                url = "https://via.placeholder.com/600/d32776"
            ),

            Photo(
                albumId = 1,
                id = 3,
                title = "Photo title 3",
                url = "https://via.placeholder.com/600/24f355"
            )
        )

        PhotoRepository.insertAll(photos)*/
    }
}
