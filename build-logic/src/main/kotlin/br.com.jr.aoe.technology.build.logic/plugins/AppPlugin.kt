package br.com.jr.aoe.technology.build.logic.plugins

import br.com.jr.aoe.technology.build.logic.config.AppConfig
import br.com.jr.aoe.technology.build.logic.extensions.getPlugin
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.Properties

class AppPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(receiver = target) {
            installPlugins(target = this)
            androidSettings(target = this)
            configureKotlin(target = this)
        }
    }

    private fun installPlugins(target: Project) {
        target.pluginManager.apply(
            target.getPlugin(alias = "android-application").pluginId
        )
        target.pluginManager.apply(
            target.getPlugin(alias = "kotlin-android").pluginId
        )
        target.pluginManager.apply(
            target.getPlugin(alias = "kotlin-compose").pluginId
        )
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

            buildTypes {
                debug {
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                    val proprieties = Properties()
                    proprieties.load(target.rootProject.file("local.properties").inputStream())
                    buildConfigField(
                        type = "String",
                        name = "URL_API",
                        value = "\"${proprieties.getProperty("URL_API_DEV")}\""
                    )
                }

                release {
                    isMinifyEnabled = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                    val proprieties = Properties()
                    proprieties.load(target.rootProject.file("local.properties").inputStream())
                    buildConfigField(
                        type = "String",
                        name = "URL_API",
                        value = "\"${proprieties.getProperty("URL_API_PROD")}\""
                    )
                }
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
