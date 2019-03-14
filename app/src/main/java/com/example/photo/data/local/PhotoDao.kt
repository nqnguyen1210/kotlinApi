package com.example.photo.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.photo.data.model.Photo

@Dao
interface PhotoDao {

    @Query("SELECT * FROM photos WHERE id = :id")
    fun getById(id: Int): LiveData<Photo>

    @Query("SELECT * FROM photos")
    fun getAllLive(): LiveData<List<Photo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(photo: Photo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Photo>)

    @Delete
    fun delete(photo: Photo)

}