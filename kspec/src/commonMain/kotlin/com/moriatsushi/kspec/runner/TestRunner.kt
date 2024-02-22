package com.moriatsushi.kspec.runner

import com.moriatsushi.kspec.KSpecTestScope
import com.moriatsushi.kspec.model.GroupDefinition
import com.moriatsushi.kspec.model.TestDefinition

internal object TestRunner {
    fun run(group: GroupDefinition) {
        for (item in group.items) {
            when (item) {
                is GroupDefinition -> run(item)
                is TestDefinition -> runTest(item)
            }
        }
    }

    fun runTest(test: TestDefinition) {
        test.body(KSpecTestScopeImpl)
    }

    private object KSpecTestScopeImpl : KSpecTestScope
}
