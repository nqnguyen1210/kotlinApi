package com.example.photo.ui.photos.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.photo.data.model.Photo
import com.example.photo.data.PhotoRepository
import com.example.photo.data.remote.PhotosResponseCallback
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class PhotosViewModel(application: Application): AndroidViewModel(application), KoinComponent {

    private val photoRepository: PhotoRepository by inject()

    var photos: LiveData<List<Photo>> = photoRepository.getAll()

    fun delete(photo: Photo) {
        photoRepository.delete(photo)
    }

    fun refresh(callback: PhotosResponseCallback) {
        photoRepository.downloadPhotos(callback)
    }
}