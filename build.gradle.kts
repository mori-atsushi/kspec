buildscript {
    repositories {
        jcenter()
        google()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
    }
}

allprojects {
    repositories {
        jcenter()
        google()
        mavenCentral()
    }
}
