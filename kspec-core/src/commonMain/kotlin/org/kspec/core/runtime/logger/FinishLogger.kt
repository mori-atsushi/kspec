package org.kspec.core.runtime.logger

import org.kspec.core.runtime.model.Block

internal class FinishLogger {
    companion object {
        private const val STACK_TRACE_COUNT = 3
    }
    fun onFinish(
        failures: List<Pair<Block.Test, Throwable>>,
        examplesCount: Int,
        failureCount: Int
    ) {
        print("\n\n")
        showFailures(failures)
        showCounts(examplesCount, failureCount)
    }

    private fun showFailures(failures: List<Pair<Block.Test, Throwable>>) {
        if (failures.isEmpty()) {
            return
        }

        print("Failures:\n\n")
        failures.forEachIndexed { index, (test, throwable) ->
            val name = Formatter.format(test.names)
            println("  $index) $name")
            print(Color.RED)
            throwable.message?.lines()?.forEach {
                println("    $it")
            }
            print(Color.CYAN)
            throwable.getStackTrace().take(STACK_TRACE_COUNT).forEach {
                println("    $it")
            }
            print(Color.RESET)
            print("\n\n")
        }
    }

    private fun showCounts(
        examplesCount: Int,
        failureCount: Int
    ) {
        val text = buildString {
            if (failureCount == 0) {
                append(Color.GREEN)
            } else {
                append(Color.RED)
            }
            append("$examplesCount examples, $failureCount failure")
            append(Color.RESET)
        }
        println(text)
    }
}
