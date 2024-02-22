package com.moriatsushi.kspec.model

import com.moriatsushi.kspec.KSpecTestScope
import kotlin.jvm.JvmInline

@JvmInline
internal value class TestDefinition(
    val body: KSpecTestScope.() -> Unit,
) : ItemDefinition
