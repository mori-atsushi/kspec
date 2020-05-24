package org.kspec.core.runtime.model

import kotlin.reflect.KClass

internal data class TypeName(
    val type: KClass<*>
) : Name {
    companion object {
        internal inline fun <reified T> from() {
            TypeName(T::class)
        }
    }

    override val value: String = type.qualifiedName.orEmpty()
}
