package org.kspec.core.runtime.logger

import org.kspec.core.runtime.model.Name

internal object Formatter {
    private const val SPACE = " "

    fun format(target: List<Name>): String {
        return target.joinToString(SPACE) {
            it.value
        }
    }
}
