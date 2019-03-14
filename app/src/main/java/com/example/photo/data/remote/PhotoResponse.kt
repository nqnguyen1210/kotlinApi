package com.example.photo.data.remote

import com.google.gson.annotations.SerializedName

data class PhotoResponse (

    @SerializedName("albumId")
    val albumId: Int,

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    var title: String,

    @SerializedName("url")
    val url: String

)