package org.kspec.core.runtime

import org.kspec.core.KSpec
import org.kspec.core.runtime.impl.GroupBodyImpl
import org.kspec.core.runtime.model.Block

internal object Collector {
    fun collect(target: KSpec): Block {
        return GroupBodyImpl.collect(target.name, target.body)
    }
}
