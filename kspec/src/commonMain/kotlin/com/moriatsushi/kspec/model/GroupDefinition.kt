package com.moriatsushi.kspec.model

internal data class GroupDefinition(
    val items: List<ItemDefinition>,
) : ItemDefinition
