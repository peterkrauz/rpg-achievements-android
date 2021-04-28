package com.peterkrauz.domain.repository

interface CrudRepository<T> {
    suspend fun getById(): T
    suspend fun getAll(): List<T>
}
