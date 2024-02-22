package com.moriatsushi.kspec

import kotlin.jvm.JvmInline

/**
 * A variable which is evaluated every test case and memoized after the first evaluation. This is
 * useful for reducing duplication between test cases that use similar values.
 */
@JvmInline
value class Let<T : Any?> internal constructor(private val name: String) {
    override fun toString(): String = "Let($name)"
}
