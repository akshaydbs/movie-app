plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`
}

group = "com.development.buildlogic"
version = "1.0.0"

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    compileOnly("com.android.tools.build:gradle:9.1.1")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:2.3.10")
}

gradlePlugin {
    plugins {
        register("movieAndroidLibrary") {
            id = "movie.android.library"
            implementationClass = "MovieAndroidLibraryConventionPlugin"
        }
    }
}