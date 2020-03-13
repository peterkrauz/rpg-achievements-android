package com.peterkrauz.home.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RpgView(
    val id: Int,
    val title: String,
    val description: String,
    val createdAt: String
) : Parcelable
