package com.example.photo.data.remote

interface PhotosResponseCallback {

    fun onSuccess()

    fun onError(throwable: Throwable)
}