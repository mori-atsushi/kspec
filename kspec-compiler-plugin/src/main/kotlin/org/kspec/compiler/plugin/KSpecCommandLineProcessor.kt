package org.kspec.compiler.plugin

import org.jetbrains.kotlin.compiler.plugin.AbstractCliOption
import org.jetbrains.kotlin.compiler.plugin.CliOption
import org.jetbrains.kotlin.compiler.plugin.CommandLineProcessor
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.config.CompilerConfigurationKey

class KSpecCommandLineProcessor : CommandLineProcessor {
    companion object {
        val KEY_ENABLED = CompilerConfigurationKey<Boolean>("enabled")
    }

    override val pluginId: String = "kspec"
    override val pluginOptions: Collection<AbstractCliOption> = listOf(
        CliOption(
            optionName = "enabled",
            valueDescription = "true or false",
            required = false,
            description = "Whether to enable this plugin or not."
        )
    )

    override fun processOption(option: AbstractCliOption, value: String, configuration: CompilerConfiguration) {
        super.processOption(option, value, configuration)
        if (option.optionName == "enabled") {
            configuration.put(KEY_ENABLED, value.toBoolean())
        }
    }
}
