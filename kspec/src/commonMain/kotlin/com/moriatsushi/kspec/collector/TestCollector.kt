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
        private val letDefinitions = mutableMapOf<Let<*>, KSpecTestScope.() -> Any?>()

        override fun describe(
            name: String,
            body: KSpecGroupScope.() -> Unit,
        ) {
            items += collect(body)
        }

        override fun after(body: KSpecTestScope.() -> Unit) {
            TODO("Not yet implemented")
        }

        override fun before(body: KSpecTestScope.() -> Unit) {
            TODO("Not yet implemented")
        }

        override fun it(
            name: String,
            body: KSpecTestScope.() -> Unit,
        ) {
            items += TestDefinition(body)
        }

        override fun <T> let(name: String): Let<T> = Let(name)

        override fun <T> let(name: String, value: KSpecTestScope.() -> T): Let<T> {
            val let = Let<T>(name)
            letDefinitions[let] = value
            return let
        }

        override fun <T> Let<T>.plusAssign(value: KSpecTestScope.() -> T) {
            letDefinitions[this] = value
        }

        fun asGroupDefinition(): GroupDefinition = GroupDefinition(
            items.toList(),
            letDefinitions.toMap(),
        )
    }
}
