package org.kspec.core.runtime.runner

import org.kspec.core.KSpec
import org.kspec.core.runtime.collector.Collector
import org.kspec.core.runtime.executor.Executor
import org.kspec.core.runtime.logger.Logger

internal class RunnerImpl(
    private val collector: Collector,
    private val executor: Executor,
    private val logger: Logger
) : Runner {
    override fun run(list: List<KSpec>): Boolean {
        logger.onBeginAll()
        list.forEach {
            val block = collector.collect(it)
            executor.execute(block, logger)
        }
        return logger.onFinishAll()
    }
}
