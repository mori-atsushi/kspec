package org.kspec.core.runtime.logger

internal class FinishLogger {
    fun onFinish(
        examplesCount: Int,
        failureCount: Int
    ) {
        print("\n\n")
        showCounts(examplesCount, failureCount)
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
