package com.peterkrauz.presentation.common_ui.base

interface BaseViewState

class Failure(val error: Throwable) : BaseViewState
object Loading : BaseViewState
