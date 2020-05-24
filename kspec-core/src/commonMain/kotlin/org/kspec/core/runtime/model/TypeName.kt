package org.kspec.core.runtime.model

import kotlin.reflect.KClass

internal data class TypeName(
    val type: KClass<*>
) : Name {
    override val value: String = type.qualifiedName.orEmpty()
}
