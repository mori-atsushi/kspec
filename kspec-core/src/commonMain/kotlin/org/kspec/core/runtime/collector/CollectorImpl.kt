package org.kspec.core.runtime.collector

import org.kspec.core.KSpec
import org.kspec.core.runtime.impl.GroupBodyImpl
import org.kspec.core.runtime.model.Block

internal class CollectorImpl : Collector {
    override fun collect(target: KSpec): Block {
        val names = listOf(target.name)
        return GroupBodyImpl.collect(names, target.body)
    }
}
