package br.com.jr.aoe.technology.build.logic.config

import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

object AppConfig {
    const val NAMESPACE = "br.com.jr.aoe.technology"
    const val PACKAGE_NAME = "br.com.jr.aoe.technology"
    const val APPLICATION_ID = "br.com.jr.aoe.technology"
    const val COMPILE_SDK = 36
    const val MIN_SDK = 24
    const val TARGET_SDK = 36
    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    const val VERSION_CODE = 1
    const val VERSION_ANDROID = "1.0.0"
    val JAVA_VERSION = JavaVersion.VERSION_21
    val JVM_TARGET = JvmTarget.JVM_21
}