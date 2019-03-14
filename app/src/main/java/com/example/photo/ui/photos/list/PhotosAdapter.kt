package com.example.photo.ui.photos.list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.photo.data.model.Photo
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.example.photo.R
import com.example.photo.databinding.ItemPhotoBinding
import com.example.photo.ui.base.BaseAdapter
import com.example.photo.ui.base.BaseViewHolder
import com.example.photo.utils.OnItemClickListener

class PhotosAdapter(lifecycleOwner: LifecycleOwner): BaseAdapter<Photo>(lifecycleOwner) {

    override fun layoutFor(position: Int): Int = R.layout.item_photo

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Photo, *> {
        val binding: ItemPhotoBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false)
        return PhotoViewHolder(binding)
    }

    class PhotoViewHolder(private val binding: ItemPhotoBinding): BaseViewHolder<Photo, ItemPhotoBinding>(binding) {

        override fun bind(lifecycleOwner: LifecycleOwner, item: Photo, listener: OnItemClickListener<Photo>) {
            super.bind(lifecycleOwner, item, listener)
            binding.title.text = item.title
        }
    }
}