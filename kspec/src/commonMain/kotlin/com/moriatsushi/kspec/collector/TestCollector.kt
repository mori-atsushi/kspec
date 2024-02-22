package com.moriatsushi.kspec.collector

import com.moriatsushi.kspec.KSpecGroupScope
import com.moriatsushi.kspec.KSpecTestScope
import com.moriatsushi.kspec.Let
import com.moriatsushi.kspec.model.GroupDefinition
import com.moriatsushi.kspec.model.ItemDefinition
import com.moriatsushi.kspec.model.TestDefinition

internal object TestCollector {
    fun collect(body: KSpecGroupScope.() -> Unit): GroupDefinition {
        val scope = KSpecGroupScopeImpl()
        scope.body()
        return scope.asGroupDefinition()
    }

    private class KSpecGroupScopeImpl : KSpecGroupScope {
        private val items = mutableListOf<ItemDefinition>()

        override fun describe(
            name: String,
            body: KSpecGroupScope.() -> Unit,
        ) {
            items += collect(body)
        }

        override fun it(
            name: String,
            body: KSpecTestScope.() -> Unit,
        ) {
            items += TestDefinition(body)
        }

        override fun <T> let(name: String): Let<T> {
            TODO("Not yet implemented")
        }

        override fun <T> let(name: String, value: KSpecTestScope.() -> T): Let<T> {
            TODO("Not yet implemented")
        }

        override fun <T> Let<T>.plusAssign(value: KSpecTestScope.() -> T) {
            TODO("Not yet implemented")
        }

        fun asGroupDefinition(): GroupDefinition = GroupDefinition(items.toList())
    }
}
