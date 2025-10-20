package br.com.jr.aoe.technology.build.logic.generic

import br.com.jr.aoe.technology.build.logic.extensions.getLibrary
import org.gradle.api.Project

fun installCommonDependencies(target: Project) {
    val libraries = listOf(
        "androidx-core-ktx",
        "androidx-lifecycle-runtime-ktx",
        "androidx-activity-compose",
        "androidx-compose-ui",
        "androidx-compose-ui-graphics",
        "androidx-compose-ui-tooling-preview"
    )
    val debugLibraries = listOf(
        "androidx-compose-ui-tooling",
        "androidx-compose-ui-test-manifest"
    )
    libraries.forEach {
        target.dependencies.add(
            "implementation",
            target.getLibrary(alias = it)
        )
    }
    debugLibraries.forEach {
        target.dependencies.add(
            "debugImplementation",
            target.getLibrary(alias = it)
        )
    }
}
