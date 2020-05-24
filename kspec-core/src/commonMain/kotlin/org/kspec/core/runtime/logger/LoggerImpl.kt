package org.kspec.core.runtime.logger

import org.kspec.core.runtime.model.Block
import org.kspec.core.runtime.model.ExecutionResult

internal class LoggerImpl : Logger {
    override fun onBegin(block: Block) {
        println("start: $block")
    }

    override fun onFinish(block: Block, result: ExecutionResult) {
        println("finish: $block, $result")
    }
}
