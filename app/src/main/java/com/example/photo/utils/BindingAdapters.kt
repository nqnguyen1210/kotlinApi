package com.example.photo.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.photo.R
import com.squareup.picasso.Picasso

@BindingAdapter("url")
fun url(view: ImageView, url: String?) {
    Picasso.get()
        .load("$url")
        .error(R.drawable.ic_error_black_24dp)
        .into(view)
}