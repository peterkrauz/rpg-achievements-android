package com.peterkrauz.home.model.mapper

import com.peterkrauz.domain.entity.Rpg
import com.peterkrauz.home.model.RpgView
import com.peterkrauz.presentation.common_ui.mapper.ViewMapper

class RpgViewMapper : ViewMapper<Rpg, RpgView> {

    override fun map(entity: Rpg): RpgView {
        return RpgView(
            entity.id,
            entity.title,
            entity.description,
            entity.createdAt
        )
    }
}
