plugins {
    `kotlin-dsl`
    `maven-publish`
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("gradle-plugin-api"))
}

group = "org.kspec"
version = "0.0.1"

gradlePlugin {
    plugins {
        register("kspec-gradle-plugin") {
            id = "kspec-gradle-plugin"
            implementationClass = "org.kspec.gradle.plugin.KSpecPlugin"
        }
    }
}

publishing {
    repositories {
        maven(url = "build/repository")
    }
}
