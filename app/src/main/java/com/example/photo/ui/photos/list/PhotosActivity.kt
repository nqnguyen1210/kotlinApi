package com.example.photo.ui.photos.list

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.photo.R
import com.example.photo.databinding.ActivityPhotosBinding
import com.example.photo.extension.showAction
import com.example.photo.extension.showError
import com.example.photo.extension.startAnimatedActivity
import com.example.photo.data.model.Photo
import com.example.photo.data.remote.PhotosResponseCallback
import com.example.photo.ui.base.BaseActivity
import com.example.photo.ui.photos.detail.DetailPhotoActivity
import org.jetbrains.anko.alert
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.noButton
import org.jetbrains.anko.yesButton
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhotosActivity : BaseActivity<PhotosViewModel, ActivityPhotosBinding>() {

    override val layout: Int = R.layout.activity_photos

    override val viewModel: PhotosViewModel by viewModel()

    private var photosAdapter = PhotosAdapter(this)

    override fun initView(savedInstanceState: Bundle?) {
        setupAdapter()
        //setupFab()
        setupRecyclerView()
        setupSwipeRefreshLayout()
    }

    private fun setupAdapter() {
        viewModel.photos.observe(this, Observer {
            photosAdapter.submitList(it)
        })

        photosAdapter.apply {
            onClick = { startAnimatedActivity(intentFor<DetailPhotoActivity>("id" to it.id)) }
            onLongClick = { showDeletePopup(it) }
        }
    }

    /*private fun setupFab() {
        binding.fab.onClick { startAnimatedActivity(intentFor<CreatePhotoActivity>()) }
    }*/

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            addItemDecoration(DividerItemDecoration(this@PhotosActivity, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(this@PhotosActivity)
            adapter = photosAdapter
        }
    }

    private fun setupSwipeRefreshLayout() {
        binding.swipeRefreshLayout.apply {

            fun refresh() {
                isRefreshing = true
                viewModel.refresh(object: PhotosResponseCallback {
                    override fun onSuccess() {
                        binding.root.showAction(getString(R.string.photos_loaded))
                        isRefreshing = false
                    }

                    override fun onError(throwable: Throwable) {
                        binding.root.showError(getString(R.string.photos_loading_error))
                        isRefreshing = false
                    }
                })
            }

            setOnRefreshListener { refresh() }
            post { refresh() }
        }
    }

    private fun showDeletePopup(photo: Photo) {
        alert(getString(R.string.delete_photo_warning)) {
            yesButton { viewModel.delete(photo) }
            noButton { }
        }.show()
    }
}