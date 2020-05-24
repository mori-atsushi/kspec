package org.kspec.core

import org.kspec.core.dsl.body.GroupBody

class KSpec {
    companion object {
        fun describe(
            name: String,
            body: GroupBody.() -> Unit
        ): KSpec {
            // TODO: set variables
            return KSpec()
        }

        inline fun <reified T> describe(
            body: GroupBody.() -> Unit
        ): KSpec {
            // TODO: set variables
            return KSpec()
        }
    }

    fun run() {
        // TODO: impl
    }
}
