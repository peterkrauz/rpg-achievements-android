package com.peterkrauz.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.peterkrauz.presentation.common_ui.extensions.inflate

class HomeAdapter(
    private val onRpgClick: (RpgView) -> Unit
) : ListAdapter<RpgView, RpgViewHolder>(RpgDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RpgViewHolder(inflate(R.layout.item_rpg, parent))

    override fun onBindViewHolder(holder: RpgViewHolder, position: Int) {
        holder.bind(getItem(position), onRpgClick)
    }

    private object RpgDiffCallback : DiffUtil.ItemCallback<RpgView>() {
        override fun areItemsTheSame(old: RpgView, new: RpgView) = old.id == new.id
        override fun areContentsTheSame(old: RpgView, new: RpgView) = old == new
    }
}
