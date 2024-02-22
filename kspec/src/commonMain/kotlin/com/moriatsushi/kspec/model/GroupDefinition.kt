package com.moriatsushi.kspec.model

import com.moriatsushi.kspec.KSpecTestScope
import com.moriatsushi.kspec.Let

internal data class GroupDefinition(
    val items: List<ItemDefinition>,
    val letDefinitions: Map<Let<*>, KSpecTestScope.() -> Any?>,
) : ItemDefinition
