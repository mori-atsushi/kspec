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
