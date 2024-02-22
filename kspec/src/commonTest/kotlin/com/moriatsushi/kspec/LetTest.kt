package com.moriatsushi.kspec

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class LetTest {
    @Test
    fun test() = KSpec.describe("Let") {
        context("When the value is set") {
            val value = let<Int>("value")
            value += { 1 }

            it("the value should be retrieved") {
                assertEquals(1, value())
            }
        }

        context("When the value has an initial value") {
            val value = let("value") { 1 }
            it("the value should be retrieved") {
                assertEquals(1, value())
            }
        }

        context("When the value is overridden") {
            val value = let("value") { 1 }
            value += { 2 }

            it("the value should be retrieved") {
                assertEquals(2, value())
            }
        }

        context("When the value is not set") {
            val value = let<Int>("value")
            it("a `IllegalStateException` should be thrown") {
                assertFailsWith<IllegalStateException> { value() }
            }
        }

        context("When the group has a nested group") {
            val value = let("value") { 1 }

            context("and the value is overridden") {
                value += { 1 }
                it("the value should be retrieved") {
                    assertEquals(1, value())
                }
            }

            context("and the value is not overridden") {
                it("the initial value should be retrieved") {
                    assertEquals(1, value())
                }
            }
        }

        context("When the value references another value") {
            val value1 = let("value1") { 1 }
            val value2 = let("value2") { value1() + 1 }

            it("the value should be calculated with the referenced value") {
                assertEquals(2, value2())
            }

            context("and the referenced value is overridden") {
                value1 += { 2 }
                it("the value should be calculated with the new value") {
                    assertEquals(3, value2())
                }
            }
        }

        context("When the value is called multiple times within the same test") {
            var count = 0
            val value = let("value") { ++count }
            it("the value should be the same") {
                assertEquals(value(), value())
            }
        }

        context("When the value is called in different tests") {
            var count = 0
            val value = let("value") { ++count }
            it("the value should be different (1)") {
                assertEquals(1, value())
            }

            it("the value should be different (2)") {
                assertEquals(2, value())
            }
        }
    }
}
