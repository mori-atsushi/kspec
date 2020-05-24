package org.kspec.core.runtime

import org.kspec.core.runtime.model.Block
import org.kspec.core.runtime.model.ExecutionResult

internal object Logger : Executor.Listener {
    override fun onBegin(block: Block) {
        println("start: $block")
    }

    override fun onFinish(block: Block, result: ExecutionResult) {
        println("finish: $block, $result")
    }
}
