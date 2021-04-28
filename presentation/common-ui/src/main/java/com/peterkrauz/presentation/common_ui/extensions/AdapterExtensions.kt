package com.peterkrauz.presentation.common_ui.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun inflate(@LayoutRes layoutId: Int, parent: ViewGroup): View {
    return LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
}
