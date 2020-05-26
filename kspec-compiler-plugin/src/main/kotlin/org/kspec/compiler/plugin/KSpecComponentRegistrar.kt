package org.kspec.compiler.plugin

import com.intellij.mock.MockProject
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration

class KSpecComponentRegistrar : ComponentRegistrar {
    override fun registerProjectComponents(project: MockProject, configuration: CompilerConfiguration) {
        if (configuration[KSpecCommandLineProcessor.KEY_ENABLED] != true) {
            return
        }
        IrGenerationExtension.registerExtension(project, KSpecExtension())
    }
}
