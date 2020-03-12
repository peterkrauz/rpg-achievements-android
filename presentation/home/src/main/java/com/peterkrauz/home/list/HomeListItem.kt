package com.peterkrauz.home.list

import com.peterkrauz.home.model.RpgView

const val RPG_ITEM_TYPE = 1
const val WELCOME_HEADER_TYPE = 2

sealed class HomeListItem {
    abstract val itemType: Int
}

class WelcomeHeaderItem(val playerName: String) : HomeListItem() {
    override val itemType = WELCOME_HEADER_TYPE
}

class RpgItem(val rpg: RpgView) : HomeListItem() {
    override val itemType = RPG_ITEM_TYPE
}
