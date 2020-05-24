package org.kspec.core.runtime.executor

import org.kspec.core.runtime.impl.TestBodyImpl
import org.kspec.core.runtime.model.Block
import org.kspec.core.runtime.model.ExecutionResult

internal class ExecutorImpl : Executor {
    override fun execute(block: Block, listener: Executor.Listener) {
        listener.onBegin(block)
        val result = ExecutionResult {
            when (block) {
                is Block.Group -> executeGroup(block, listener)
                is Block.Test -> executeTest(block)
            }
        }
        listener.onFinish(block, result)
    }

    private fun executeGroup(
        block: Block.Group,
        listener: Executor.Listener
    ) {
        block.blocks.forEach {
            execute(it, listener)
        }
    }

    private fun executeTest(
        block: Block.Test
    ) {
        val body = TestBodyImpl()
        block.body.invoke(body)
    }
}
