package com.peterkrauz.domain.mapper

interface Mapper<I, O> {
    fun map(dto: I): O
}
