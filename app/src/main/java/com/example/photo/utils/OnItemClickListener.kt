package com.example.photo.utils

import com.example.photo.data.model.BaseObject


interface OnItemClickListener<T: BaseObject> {

    fun onItemClick(item: T)

    fun onItemLongClick(item: T): Boolean

}