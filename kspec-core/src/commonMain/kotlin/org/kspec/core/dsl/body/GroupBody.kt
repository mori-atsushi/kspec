package org.kspec.core.dsl.body

import org.kspec.core.meta.KSpecDsl

@KSpecDsl
interface GroupBody {
    fun describe(name: String, body: GroupBody.() -> Unit)
    fun context(name: String, body: GroupBody.() -> Unit)

    fun example(name: String, body: TestBody.() -> Unit)
    fun it(name: String? = null, body: TestBody.() -> Unit)
}
