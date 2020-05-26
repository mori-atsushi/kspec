plugins {
    kotlin("jvm")
    id("kspec-gradle-plugin") version "0.0.1"
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(project(":kspec-core"))
}
