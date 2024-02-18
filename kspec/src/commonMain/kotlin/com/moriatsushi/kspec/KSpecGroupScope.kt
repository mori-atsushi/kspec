package com.moriatsushi.kspec

@KSpecDsl
interface KSpecGroupScope {
    fun describe(
        name: String,
        body: KSpecGroupScope.() -> Unit,
    )

    fun context(
        name: String,
        body: KSpecGroupScope.() -> Unit,
    ) = describe(name, body)

    fun it(
        name: String,
        body: KSpecTestScope.() -> Unit,
    )
}

internal class KSpecGroupScopeImpl : KSpecGroupScope {
    override fun describe(
        name: String,
        body: KSpecGroupScope.() -> Unit,
    ) {
        KSpecGroupScopeImpl().body()
    }

    override fun it(
        name: String,
        body: KSpecTestScope.() -> Unit,
    ) {
        KSpecTestScopeImpl().body()
    }
}
