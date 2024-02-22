package com.moriatsushi.kspec.model

import kotlin.jvm.JvmInline

@JvmInline
internal value class NullableHolder<T : Any?>(val value: T?)
