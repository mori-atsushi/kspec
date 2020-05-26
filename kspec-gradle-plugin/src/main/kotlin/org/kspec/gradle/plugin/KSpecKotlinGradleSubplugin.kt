package org.kspec.gradle.plugin

import org.gradle.api.Project
import org.gradle.api.tasks.compile.AbstractCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinCommonOptions
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation
import org.jetbrains.kotlin.gradle.plugin.KotlinGradleSubplugin
import org.jetbrains.kotlin.gradle.plugin.SubpluginArtifact
import org.jetbrains.kotlin.gradle.plugin.SubpluginOption

class KSpecKotlinGradleSubplugin : KotlinGradleSubplugin<AbstractCompile> {
    override fun apply(
        project: Project,
        kotlinCompile: AbstractCompile,
        javaCompile: AbstractCompile?,
        variantData: Any?,
        androidProjectHandler: Any?,
        kotlinCompilation: KotlinCompilation<KotlinCommonOptions>?
    ): List<SubpluginOption> {
        val extension = project.extensions.findByType(KSpecExtension::class.java) ?: return emptyList()
        return listOf(
            SubpluginOption("enabled", extension.enabled.toString())
        )
    }

    override fun getCompilerPluginId(): String = "kspec"

    override fun getPluginArtifact(): SubpluginArtifact {
        return SubpluginArtifact(
            "org.kspec",
            "spek-compiler-plugin",
            "0.0.1"
        )
    }

    override fun isApplicable(project: Project, task: AbstractCompile): Boolean {
        return true
    }
}
