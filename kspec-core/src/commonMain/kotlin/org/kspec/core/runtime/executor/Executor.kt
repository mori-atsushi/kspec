package org.kspec.core.runtime.executor

import org.kspec.core.runtime.model.Block
import org.kspec.core.runtime.model.ExecutionResult

internal interface Executor {
    fun execute(block: Block, listener: Listener)

    interface Listener {
        fun onBegin(block: Block)
        fun onFinish(block: Block, result: ExecutionResult)
    }
}
