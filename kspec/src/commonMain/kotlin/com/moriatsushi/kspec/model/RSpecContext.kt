package com.moriatsushi.kspec.model

import com.moriatsushi.kspec.KSpecTestScope
import com.moriatsushi.kspec.Let
import kotlin.jvm.JvmInline

@JvmInline
internal value class RSpecContext(
    private val letDefinitions: Map<Let<*>, KSpecTestScope.() -> Any?> = emptyMap(),
) {
    @Suppress("UNCHECKED_CAST")
    fun <T> findLetDefinition(let: Let<T>): (KSpecTestScope.() -> T?)? =
        letDefinitions[let] as? KSpecTestScope.() -> T?

    operator fun plus(context: RSpecContext): RSpecContext =
        RSpecContext(letDefinitions + context.letDefinitions)
}
