package org.kspec.core.runtime.logger

import org.kspec.core.runtime.model.Block
import org.kspec.core.runtime.model.ExecutionResult

internal class LoggerImpl : Logger {
    private val progressLogger = ProgressLogger()

    private var isSuccess = true

    override fun onBeginAll() {
    }

    override fun onBegin(block: Block) {
    }

    override fun onFinish(block: Block, result: ExecutionResult) {
        if (block.isTest) {
            progressLogger.onFinish(result.isSuccess)
            if (result.isFailure) {
                isSuccess = false
            }
        }
    }

    override fun onFinishAll(): Boolean {
        return isSuccess
    }
}
