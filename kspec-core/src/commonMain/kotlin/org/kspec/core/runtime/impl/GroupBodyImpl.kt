package org.kspec.core.runtime.impl

import org.kspec.core.dsl.body.GroupBody
import org.kspec.core.dsl.body.TestBody
import org.kspec.core.runtime.model.Block
import org.kspec.core.runtime.model.Name
import org.kspec.core.runtime.model.StringName

internal class GroupBodyImpl private constructor(
    private val names: List<Name>
) : GroupBody {
    companion object {
        fun collect(names: List<Name>, body: GroupBody.() -> Unit): Block {
            val groupBody = GroupBodyImpl(names)
            body.invoke(groupBody)
            return groupBody.toBlock()
        }
    }

    private val blocks = mutableListOf<Block>()

    override fun describe(name: String, body: GroupBody.() -> Unit) {
        group(StringName(name), body)
    }

    override fun context(name: String, body: GroupBody.() -> Unit) {
        group(StringName(name), body)
    }

    private fun group(name: Name, body: GroupBody.() -> Unit) {
        val block = collect(names + name, body)
        blocks.add(block)
    }

    override fun example(name: String, body: TestBody.() -> Unit) {
        test(StringName(name), body)
    }

    override fun it(name: String?, body: TestBody.() -> Unit) {
        val stringName = name?.let { StringName(it) }
        test(stringName, body)
    }

    private fun test(name: Name?, body: TestBody.() -> Unit) {
        val names = name?.let { names + it } ?: names
        val test = Block.Test(names, body)
        this.blocks.add(test)
    }

    private fun toBlock(): Block.Group {
        return Block.Group(
            names = names,
            blocks = blocks
        )
    }
}
