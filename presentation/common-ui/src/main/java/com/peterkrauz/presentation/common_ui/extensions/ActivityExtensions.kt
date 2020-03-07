package com.peterkrauz.presentation.common_ui.extensions

import android.view.View
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.peterkrauz.presentation.common_ui.R

fun Fragment.paintStatusBar(color: Int) {
    with(requireActivity().window) {
        clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        statusBarColor = ContextCompat.getColor(context, color)
    }
}

fun Fragment.snackBar(
    view: View,
    msg: String,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionMsg: Int = R.string.ok,
    action: () -> Unit = { }
) {
    Snackbar
        .make(view, msg, duration)
        .setAction(getString(actionMsg)) { action.invoke() }
        .setActionTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
        .show()
}
