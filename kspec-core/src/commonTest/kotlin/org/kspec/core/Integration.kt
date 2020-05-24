package org.kspec.core

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Integration {
    @Test
    fun success() {
        val test = KSpec.describe("root") {
            context("context") {
                example("test") {
                    println("success")
                }
            }
        }
        assertTrue(test.run())
    }

    @Test
    fun failure() {
        val test = KSpec.describe("root") {
            context("context") {
                example("test") {
                    throw Exception("failure")
                }
            }
        }
        assertFalse(test.run())
    }
}
