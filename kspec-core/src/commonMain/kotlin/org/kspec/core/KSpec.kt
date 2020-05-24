package org.kspec.core

import org.kspec.core.dsl.body.GroupBody
import org.kspec.core.runtime.InstanceContainer
import org.kspec.core.runtime.model.Name
import org.kspec.core.runtime.model.StringName
import org.kspec.core.runtime.model.TypeName
import kotlin.reflect.KClass

class KSpec private constructor(
    internal val name: Name,
    internal val body: GroupBody.() -> Unit
) {
    companion object {
        fun describe(
            name: String,
            body: GroupBody.() -> Unit
        ): KSpec {
            return KSpec(
                name = StringName(name),
                body = body
            )
        }

        inline fun <reified T> describe(
            noinline body: GroupBody.() -> Unit
        ): KSpec {
            return describe(T::class, body)
        }

        fun describe(
            name: KClass<*>,
            body: GroupBody.() -> Unit
        ): KSpec {
            return KSpec(
                name = TypeName(name),
                body = body
            )
        }

        fun run(vararg items: KSpec): Boolean {
            val runner = InstanceContainer.newRunner()
            return runner.run(items.toList())
        }
    }

    fun run(): Boolean {
        return run(this)
    }
}
