package org.kspec.gradle.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class KSpecPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.extensions.create(
            "kspec",
            KSpecExtension::class.java
        )
    }
}
