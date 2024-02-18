package com.moriatsushi.kspec

import kotlin.test.Test

class KSpecTest {
    @Test
    fun test() =
        KSpec.describe("KSpec") {
            it("should be able to run a test") {
                println("Hello, KSpec!")
            }
        }
}
