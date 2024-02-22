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

    /**
     * Runs the given [body] before each test in this group.
     */
    fun before(body: KSpecTestScope.() -> Unit)

    /**
     * Runs the given [body] after each test in this group.
     */
    fun after(body: KSpecTestScope.() -> Unit)

    fun it(
        name: String,
        body: KSpecTestScope.() -> Unit,
    )

    /**
     * Creates a [Let] without an initial value.
     */
    fun <T> let(name: String): Let<T>

    /**
     * Creates a [Let] with an initial value.
     */
    fun <T> let(
        name: String,
        value: KSpecTestScope.() -> T,
    ): Let<T>

    /**
     * Sets or overrides the value of the [Let].
     */
    operator fun <T> Let<T>.plusAssign(value: KSpecTestScope.() -> T)
}
