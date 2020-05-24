package org.kspec.core.runtime.collector

import org.kspec.core.KSpec
import org.kspec.core.runtime.model.Block

internal interface Collector {
    fun collect(target: KSpec): Block
}
