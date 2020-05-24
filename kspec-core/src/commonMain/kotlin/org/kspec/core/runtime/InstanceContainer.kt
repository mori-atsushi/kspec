package org.kspec.core.runtime

import org.kspec.core.runtime.collector.Collector
import org.kspec.core.runtime.collector.CollectorImpl
import org.kspec.core.runtime.executor.Executor
import org.kspec.core.runtime.executor.ExecutorImpl
import org.kspec.core.runtime.logger.Logger
import org.kspec.core.runtime.logger.LoggerImpl
import org.kspec.core.runtime.runner.Runner
import org.kspec.core.runtime.runner.RunnerImpl

internal object InstanceContainer {
    fun newRunner(): Runner {
        return RunnerImpl(
            collector = newCollector(),
            executor = newExecutor(),
            logger = newLogger()
        )
    }

    private fun newCollector(): Collector {
        return CollectorImpl()
    }

    private fun newExecutor(): Executor {
        return ExecutorImpl()
    }

    private fun newLogger(): Logger {
        return LoggerImpl()
    }
}
