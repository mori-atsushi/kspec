package com.moriatsushi.kspec

object KSpec {
    fun describe(
        name: String,
        body: KSpecGroupScope.() -> Unit,
    ) {
        KSpecGroupScopeImpl().body()
    }
}
