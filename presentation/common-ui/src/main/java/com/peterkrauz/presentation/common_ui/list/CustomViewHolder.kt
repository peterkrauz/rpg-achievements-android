package com.peterkrauz.presentation.common_ui.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class CustomViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(item: T, onItemClick: (T) -> Unit)
}
