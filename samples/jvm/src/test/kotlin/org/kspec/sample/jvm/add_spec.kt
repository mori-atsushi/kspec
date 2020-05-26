package org.kspec.sample.jvm

import org.kspec.core.KSpec

val add = KSpec.describe("add") {
    context("1 + 1") {
        it("= 2") {
            val actual = 1 + 1
            assert(actual == 2)
        }
    }

    context("1 - 1") {
        it("= 0") {
            val actual = 1 - 1
            assert(actual == 0)
        }
    }
}
