package br.com.jr.aoe.technology.build.logic.plugins

import br.com.jr.aoe.technology.build.logic.config.AppConfig
import br.com.jr.aoe.technology.build.logic.extensions.getPlugin
import br.com.jr.aoe.technology.build.logic.generic.installCommonDependencies
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class LibraryPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(receiver = target) {
            installPlugins(target = this)
            installCommonDependencies(target = this)
            androidSettings(target = this)
            configureKotlin(target = this)
        }
    }

    private fun installPlugins(target: Project) {
        val libraries = listOf(
            "android-library",
            "kotlin-android",
            "kotlin-compose"
        )
        libraries.forEach {
            target.pluginManager.apply(target.getPlugin(alias = it).pluginId)
        }
    }

    private fun androidSettings(target: Project) {
        target.extensions.configure<LibraryExtension> {
            compileSdk = AppConfig.COMPILE_SDK

            defaultConfig {
                minSdk = AppConfig.MIN_SDK
                testInstrumentationRunner = AppConfig.TEST_INSTRUMENTATION_RUNNER
            }

            packaging {
                resources {
                    excludes += "/META-INF/{AL2.0,LGPL2.1}"
                }
            }

            compileOptions {
                sourceCompatibility = AppConfig.JAVA_VERSION
                targetCompatibility = AppConfig.JAVA_VERSION
            }

            buildFeatures {
                buildConfig = true
                compose = true
            }
        }
    }

    private fun configureKotlin(target: Project) {
        target.tasks.withType<KotlinCompile>().configureEach {
            compilerOptions {
                jvmTarget.set(AppConfig.JVM_TARGET)
            }
        }
    }
}
