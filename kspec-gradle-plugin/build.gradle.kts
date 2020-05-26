plugins {
    `kotlin-dsl`
    `maven-publish`
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("gradle-plugin-api"))
}

gradlePlugin {
    plugins {
        create("KSpecPlugin") {
            id = "org.kspec"
            implementationClass = "org.kspec.gradle.plugin.KSpecPlugin"
        }
    }
}

publishing {
    repositories {
        maven(url = "build/repository")
    }
}
