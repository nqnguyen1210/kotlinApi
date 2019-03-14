package com.example.photo.ui.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.photo.BR
import com.example.photo.data.model.BaseObject
import com.example.photo.utils.OnItemClickListener

abstract class BaseViewHolder<T: BaseObject, V: ViewDataBinding>(private val viewDataBinding: V): RecyclerView.ViewHolder(viewDataBinding.root) {

    protected lateinit var item: T

    open fun bind(lifecycleOwner: LifecycleOwner, item: T, listener: OnItemClickListener<T>) {
        this.item = item
        viewDataBinding.setLifecycleOwner(lifecycleOwner)
        viewDataBinding.setVariable(BR.item, item)
        viewDataBinding.setVariable(BR.listener, listener)
        viewDataBinding.executePendingBindings()
    }
}