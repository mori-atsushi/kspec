pluginManagement {
    repositories {
        gradlePluginPortal()
        maven { url = uri("kspec-gradle-plugin/build/repository") }
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.jetbrains.kotlin.multiplatform") {
                useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
            }
        }
    }
}

rootProject.name = "kspec"
include(
    ":kspec-core",
    ":kspec-compiler-plugin",
    ":kspec-gradle-plugin",
    ":samples:jvm"
)
