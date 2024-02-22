package com.moriatsushi.kspec

import kotlin.test.Test
import kotlin.test.assertEquals

class BeforeAfterTest {
    @Test
    fun test() = KSpec.describe("Before/After") {
        context("When a test has before and after blocks") {
            it("these blocks should be run") {
                var step = 0
                KSpec.describe("sample") {
                    before { assertEquals(0, step++) }

                    after { assertEquals(2, step++) }

                    it("test") { assertEquals(1, step++) }
                }
                assertEquals(3, step)
            }

            it("these blocks should be run for each test") {
                var beforeCount = 0
                var afterCount = 0
                KSpec.describe("sample") {
                    before { beforeCount++ }
                    after { afterCount++ }

                    it("test1") {}
                    it("test2") {}
                    it("test3") {}
                }
                assertEquals(3, beforeCount)
                assertEquals(3, afterCount)
            }
        }

        context("When a test has nested before and after blocks") {
            it("these blocks should be run") {
                var step = 0
                KSpec.describe("sample") {
                    before { assertEquals(0, step++) }

                    after { assertEquals(4, step++) }

                    context("nested context") {
                        before { assertEquals(1, step++) }

                        after { assertEquals(3, step++) }

                        it("test") { assertEquals(2, step++) }
                    }
                }
                assertEquals(5, step)
            }
        }

        context("When a test has multiple before and after blocks") {
            it("these blocks should be run") {
                var step = 0
                KSpec.describe("sample") {
                    before { assertEquals(0, step++) }

                    before { assertEquals(1, step++) }

                    after { assertEquals(3, step++) }

                    after { assertEquals(4, step++) }

                    it("test") { assertEquals(2, step++) }
                }
                assertEquals(5, step)
            }
        }
    }
}
