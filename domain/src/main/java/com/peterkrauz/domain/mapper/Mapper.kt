package com.peterkrauz.domain.mapper

/**
 * Dto goes in,
 * Entity goes out
 */
interface Mapper<D, E> {
    fun map(dto: D): E
}
