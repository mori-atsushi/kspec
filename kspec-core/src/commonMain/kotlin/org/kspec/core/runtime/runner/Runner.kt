package org.kspec.core.runtime.runner

import org.kspec.core.KSpec

internal interface Runner {
    fun run(list: List<KSpec>): Boolean
}
