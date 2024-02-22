package com.moriatsushi.kspec

import com.moriatsushi.kspec.collector.TestCollector
import com.moriatsushi.kspec.runner.TestRunner

object KSpec {
    fun describe(
        name: String,
        body: KSpecGroupScope.() -> Unit,
    ) {
        val group = TestCollector.collect(body)
        TestRunner.run(group)
    }
}
