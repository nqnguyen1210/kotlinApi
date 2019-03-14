package com.example.photo.ui.photos.detail

import android.os.Bundle
import com.example.photo.R
import com.example.photo.databinding.ActivityDetailPhotoBinding
import com.example.photo.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailPhotoActivity : BaseActivity<DetailPhotoViewModel, ActivityDetailPhotoBinding>() {

    override val layout: Int = R.layout.activity_detail_photo

    override val viewModel: DetailPhotoViewModel by viewModel()

    override fun initView(savedInstanceState: Bundle?) {
        viewModel.photoId.value = intent.getIntExtra("id", 0)
        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
