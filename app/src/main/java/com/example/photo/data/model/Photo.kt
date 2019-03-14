package com.example.photo.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.photo.data.model.BaseObject
import io.reactivex.annotations.NonNull

@Entity(tableName = "photos")
data class Photo (

    val albumId: Int = 0,

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    override var id: Int = 0,

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "url")
    val url: String? = null

): BaseObject