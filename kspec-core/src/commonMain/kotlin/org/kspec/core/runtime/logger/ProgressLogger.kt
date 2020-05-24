package org.kspec.core.runtime.logger

internal class ProgressLogger {
    companion object {
        private const val SUCCESS = "${Color.GREEN}.${Color.RESET}"
        private const val FAILURE = "${Color.RED}F${Color.RESET}"
    }

    fun onFinish(isSuccess: Boolean) {
        val key = if (isSuccess) {
            SUCCESS
        } else {
            FAILURE
        }
        print(key)
    }
}
