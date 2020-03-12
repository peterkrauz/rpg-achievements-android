package com.peterkrauz.home.model

import android.os.Parcelable
import com.peterkrauz.presentation.common_ui.list.Recyclable
import kotlinx.android.parcel.Parcelize
import org.threeten.bp.LocalDate

@Parcelize
data class RpgView(
    val id: Int,
    val title: String,
    val description: String,
    val createdAt: LocalDate
) : Parcelable
