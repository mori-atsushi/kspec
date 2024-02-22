package com.moriatsushi.kspec

@KSpecDsl
interface KSpecTestScope {
    /**
     * Evaluates the value of the [Let] and returns it, or returns the memoized value if it has
     * already been evaluated.
     *
     * @throws IllegalStateException if the value is not set.
     */
    operator fun <T> Let<T>.invoke(): T
}
