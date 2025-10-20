package br.com.jr.aoe.technology.build.logic.plugins

import br.com.jr.aoe.technology.build.logic.config.AppConfig
import br.com.jr.aoe.technology.build.logic.extensions.getPlugin
import br.com.jr.aoe.technology.build.logic.generic.installCommonDependencies
import br.com.jr.aoe.technology.build.logic.libraries.librariesAppPlugin
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class AppPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(receiver = target) {
            installPlugins(target = this)
            installCommonDependencies(target = this)
            androidSettings(target = this)
            configureKotlin(target = this)
        }
    }

    private fun installPlugins(target: Project) {
        librariesAppPlugin.forEach {
            target.pluginManager.apply(target.getPlugin(alias = it).pluginId)
        }
    }

    private fun androidSettings(target: Project) {

        target.extensions.configure<BaseAppModuleExtension> {
            namespace = AppConfig.NAMESPACE
            compileSdk = AppConfig.COMPILE_SDK

            defaultConfig {
                applicationId = AppConfig.APPLICATION_ID
                minSdk = AppConfig.MIN_SDK
                targetSdk = AppConfig.TARGET_SDK
                versionCode = AppConfig.VERSION_CODE
                versionName = AppConfig.VERSION_ANDROID
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
