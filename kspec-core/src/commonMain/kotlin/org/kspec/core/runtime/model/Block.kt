package org.kspec.core.runtime.model

import org.kspec.core.dsl.body.TestBody

internal sealed class Block {
    data class Group(
        val name: Name,
        val blocks: List<Block>
    ) : Block()

    data class Test(
        val name: Name?,
        val body: TestBody.() -> Unit
    ) : Block()

    val isGroup get() = this is Group
    val isTest get() = this is Test
}
