package com.moriatsushi.kspec.model

import com.moriatsushi.kspec.KSpecTestScope
import com.moriatsushi.kspec.Let

internal class RSpecContext(
    val beforeDefinitions: List<KSpecTestScope.() -> Unit>,
    val afterDefinitions: List<KSpecTestScope.() -> Unit>,
    val letDefinitions: Map<Let<*>, KSpecTestScope.() -> Any?>,
) {
    operator fun plus(context: RSpecContext): RSpecContext =
        RSpecContext(
            beforeDefinitions = beforeDefinitions + context.beforeDefinitions,
            // The after blocks should be executed in the reverse order of the before blocks.
            afterDefinitions = context.afterDefinitions + afterDefinitions,
            letDefinitions = letDefinitions + context.letDefinitions,
        )

    companion object {
        val Empty = RSpecContext(emptyList(), emptyList(), emptyMap())
    }
}
