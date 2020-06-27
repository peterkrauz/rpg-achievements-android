package com.peterkrauz.presentation.common_ui.extensions

import android.content.res.Resources
import androidx.annotation.ColorRes
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment

fun Fragment.getColorCompat(
    @ColorRes colorId: Int,
    theme: Resources.Theme? = null
): Int {
    return ResourcesCompat.getColor(resources, colorId, theme)
}
