package com.example.photo.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.photo.data.local.PhotoDao
import com.example.photo.data.local.PhotoDatabase
import com.example.photo.data.model.Photo
import com.example.photo.data.remote.PhotoResponse
import com.example.photo.data.remote.PhotoService
import com.example.photo.data.remote.PhotosResponseCallback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class PhotoRepository: KoinComponent {

    private val photoDao: PhotoDao by inject()

    private val service = PhotoService.create()

    //region locale

    fun insertAll(photos: List<Photo>) = doAsync {
        photoDao.insertAll(photos)
        Log.d("photoRepository","inserting photos: $photos")
    }

    fun insert(photo: Photo) =
        insertAll(listOf(photo))

    fun delete(photo: Photo) = doAsync { photoDao.delete(photo) }

    fun getById(id: Int): LiveData<Photo> = photoDao.getById(id)

    fun getAll(): LiveData<List<Photo>> = photoDao.getAllLive()

    //endregion

    //region remote

    fun downloadPhotos(callback: PhotosResponseCallback) {
        service.getAllPhotos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = { photosList ->
                    insertAll(photosList.map { photoResponse ->
                        photoResponseToPhoto(
                            photoResponse
                        )
                    })
                },
                onComplete = { callback.onSuccess() },
                onError = { callback.onError(it) }
            )
    }

    private fun photoResponseToPhoto(photoResponse: PhotoResponse): Photo =
        Photo(
            albumId = photoResponse.albumId,
            id = photoResponse.id,
            title = photoResponse.title,
            url = photoResponse.url
        )

    //endregion
}