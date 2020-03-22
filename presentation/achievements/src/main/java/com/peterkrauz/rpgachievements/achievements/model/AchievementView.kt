package com.peterkrauz.rpgachievements.achievements.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AchievementView(
    val id: Int,
    val title: String,
    val description: String
) : Parcelable