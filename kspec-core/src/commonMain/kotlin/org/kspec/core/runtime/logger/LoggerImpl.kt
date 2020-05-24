package org.kspec.core.runtime.logger

import org.kspec.core.runtime.model.Block
import org.kspec.core.runtime.model.ExecutionResult

internal class LoggerImpl : Logger {
    private val progressLogger = ProgressLogger()
    private val finishLogger = FinishLogger()

    private var isSuccess = true
    private var examplesCount = 0
    private var failureCount = 0
    private val failures = mutableListOf<Pair<Block.Test, Throwable>>()

    override fun onBeginAll() {
    }

    override fun onBegin(block: Block) {
    }

    override fun onFinish(block: Block, result: ExecutionResult) {
        if (block is Block.Test) {
            examplesCount += 1
            progressLogger.onFinish(result.isSuccess)
            if (result is ExecutionResult.Failure) {
                failures.add(block to result.cause)
                failureCount += 1
                isSuccess = false
            }
        }
    }

    override fun onFinishAll(): Boolean {
        finishLogger.onFinish(
            failures = failures,
            examplesCount = examplesCount,
            failureCount = failureCount
        )
        return isSuccess
    }
}
