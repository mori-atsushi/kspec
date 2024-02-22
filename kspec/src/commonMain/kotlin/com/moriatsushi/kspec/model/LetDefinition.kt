package com.moriatsushi.kspec.model

import com.moriatsushi.kspec.KSpecTestScope

internal data class LetDefinition(
    val value: KSpecTestScope.() -> Any?,
)
