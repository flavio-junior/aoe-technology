plugins {
    `kotlin-dsl`
    `version-catalog`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(dependencyNotation = libs.kotlin.gradle.plugin)
    implementation(dependencyNotation = libs.android.library.gradle.plugin)
    implementation(dependencyNotation = libs.android.application.gradle.plugin)
}

gradlePlugin {
    plugins {
        create("aoe.technology.application") {
            id = "br.com.jr.aoe.technology.application"
            implementationClass = "br.com.jr.aoe.technology.build.logic.plugins.AppPlugin"
        }
        create("aoe.technology.library") {
            id = "br.com.jr.aoe.technology.library"
            implementationClass = "br.com.jr.aoe.technology.build.logic.plugins.LibraryPlugin"
        }
    }
}
