package com.example.photo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.photo.data.model.Photo

@Database(entities = [Photo::class], version = 1, exportSchema = false)
abstract class PhotoDatabase : RoomDatabase() {

    abstract fun photoDao(): PhotoDao

    companion object {

        const val DATABASE_NAME = "PhotoDatabase"
    }
}