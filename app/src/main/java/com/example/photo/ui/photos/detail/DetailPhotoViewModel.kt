package com.example.photo.ui.photos.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.photo.data.model.Photo
import com.example.photo.data.PhotoRepository
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class DetailPhotoViewModel(application: Application): AndroidViewModel(application), KoinComponent {

    private val photoRepository: PhotoRepository by inject()

    var photoId: MutableLiveData<Int> = MutableLiveData()

    var photo: LiveData<Photo> = Transformations.switchMap(photoId) { id -> photoRepository.getById(id) }
}