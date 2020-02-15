package com.peterkrauz.domain.repository

import com.peterkrauz.domain.entity.Rpg

interface RpgRepository {
    fun getAll(): List<Rpg>
    fun getById(): Rpg
}
