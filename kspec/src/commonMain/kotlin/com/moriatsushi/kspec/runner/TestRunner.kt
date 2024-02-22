package com.moriatsushi.kspec.runner

import com.moriatsushi.kspec.KSpecTestScope
import com.moriatsushi.kspec.Let
import com.moriatsushi.kspec.model.GroupDefinition
import com.moriatsushi.kspec.model.NullableHolder
import com.moriatsushi.kspec.model.RSpecContext
import com.moriatsushi.kspec.model.TestDefinition

internal object TestRunner {
    fun run(group: GroupDefinition) {
        run(group, RSpecContext.Empty)
    }

    private fun run(group: GroupDefinition, context: RSpecContext) {
        val newContext = context + RSpecContext(
            beforeDefinitions = group.beforeDefinitions,
            afterDefinitions = group.afterDefinitions,
            letDefinitions = group.letDefinitions,
        )
        for (item in group.items) {
            when (item) {
                is GroupDefinition -> run(item, newContext)
                is TestDefinition -> runTest(item, newContext)
            }
        }
    }

    private fun runTest(test: TestDefinition, context: RSpecContext) {
        for (before in context.beforeDefinitions) {
            before(KSpecTestScopeImpl(context))
        }
        test.body(KSpecTestScopeImpl(context))
        for (after in context.afterDefinitions) {
            after(KSpecTestScopeImpl(context))
        }
    }

    private class KSpecTestScopeImpl(
        private val context: RSpecContext,
    ) : KSpecTestScope {
        private val letValues = mutableMapOf<Let<*>, NullableHolder<Any?>>()

        override fun <T> Let<T>.invoke(): T {
            val scope = this@KSpecTestScopeImpl
            val holder = letValues.getOrPut(this) {
                val definition = context.letDefinitions[this]
                    ?: error("The value of $this is not specified")
                NullableHolder(definition.invoke(scope))
            }
            @Suppress("UNCHECKED_CAST")
            return holder.value as T
        }
    }
}
