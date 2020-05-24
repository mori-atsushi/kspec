package org.kspec.core.runtime.model

import org.kspec.core.dsl.body.TestBody

internal sealed class Block {
    abstract val names: List<Name>

    data class Group(
        override val names: List<Name>,
        val blocks: List<Block>
    ) : Block()

    data class Test(
        override val names: List<Name>,
        val body: TestBody.() -> Unit
    ) : Block()

    val isGroup get() = this is Group
    val isTest get() = this is Test
}
