package org.kspec.core.runtime

import org.kspec.core.runtime.impl.TestBodyImpl
import org.kspec.core.runtime.model.Block
import org.kspec.core.runtime.model.ExecutionResult

internal object Executor {
    fun execute(block: Block, listener: Listener) {
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
        listener: Listener
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

    interface Listener {
        fun onBegin(block: Block)
        fun onFinish(block: Block, result: ExecutionResult)
    }
}
