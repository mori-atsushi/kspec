package com.moriatsushi.kspec.model

import com.moriatsushi.kspec.KSpecTestScope
import com.moriatsushi.kspec.Let

internal class GroupDefinition(
    val items: List<ItemDefinition>,
    val beforeDefinitions: List<KSpecTestScope.() -> Unit>,
    val afterDefinitions: List<KSpecTestScope.() -> Unit>,
    val letDefinitions: Map<Let<*>, KSpecTestScope.() -> Any?>,
) : ItemDefinition
