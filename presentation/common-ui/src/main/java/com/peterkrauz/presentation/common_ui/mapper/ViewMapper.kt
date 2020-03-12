package com.peterkrauz.presentation.common_ui.mapper

/**
 * Entity goes in,
 * View goes out
 */
interface ViewMapper<E, V> {
    fun map(entity: E): V
}
