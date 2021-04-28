package com.peterkrauz.presentation.common_ui.list

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

//abstract class CustomAdapter<T : Recyclable>: ListAdapter<T, CustomViewHolder<T>>(DiffCallback) {
//
//    abstract val onItemClick: ((Recyclable) -> Unit)
//
//    override fun onBindViewHolder(holder: CustomViewHolder<Recyclable>, position: Int) {
//        holder.bind(getItem(position), onItemClick)
//    }
//
//    object DiffCallback<out T : Recyclable> : DiffUtil.ItemCallback<T>() {
//        override fun areItemsTheSame(old: Recyclable, new: Recyclable) = old.id == new.id
//        override fun areContentsTheSame(old: Recyclable, new: Recyclable) = old.equals(new)
//    }
//}