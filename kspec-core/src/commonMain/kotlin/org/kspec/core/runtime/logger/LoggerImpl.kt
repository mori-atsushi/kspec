package org.kspec.core.runtime.logger

import org.kspec.core.runtime.model.Block
import org.kspec.core.runtime.model.ExecutionResult

internal class LoggerImpl : Logger {
    private var isSuccess = true

    override fun onBeginAll() {
    }

    override fun onBegin(block: Block) {
        println("start: $block")
    }

    override fun onFinish(block: Block, result: ExecutionResult) {
        println("finish: $block, $result")
        if (result.isFailure) {
            isSuccess = false
        }
    }

    override fun onFinishAll(): Boolean {
        return isSuccess
    }
}
