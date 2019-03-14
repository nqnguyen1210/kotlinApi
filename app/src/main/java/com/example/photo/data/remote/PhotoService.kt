package com.example.photo.data.remote

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotoService {

    @GET("photos")
    fun getAllPhotos(): Observable<List<PhotoResponse>>

    @GET("photos/{photos}")
    fun getPhoto(@Path("photos") id: Int): Observable<PhotoResponse>

    companion object {

        fun create(): PhotoService {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(PhotoService::class.java)
        }
    }
}