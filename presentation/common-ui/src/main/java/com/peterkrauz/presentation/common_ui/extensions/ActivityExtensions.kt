package com.peterkrauz.presentation.common_ui.extensions

import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Fragment.paintStatusBar(color: Int) {
    with(requireActivity().window) {
        clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        statusBarColor = ContextCompat.getColor(context, color)
    }
}
