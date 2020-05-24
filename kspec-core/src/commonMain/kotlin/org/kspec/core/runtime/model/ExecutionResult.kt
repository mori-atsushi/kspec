package org.kspec.core.runtime.model

internal sealed class ExecutionResult {
    companion object {
        operator fun invoke(f: () -> Unit): ExecutionResult {
            return try {
                f()
                Success
            } catch (e: Throwable) {
                Failure(e)
            }
        }
    }

    object Success : ExecutionResult()

    data class Failure(
        val cause: Throwable
    ) : ExecutionResult()

    val isSuccess
        get() = this is Success
    val isFailure
        get() = this is Failure
}
