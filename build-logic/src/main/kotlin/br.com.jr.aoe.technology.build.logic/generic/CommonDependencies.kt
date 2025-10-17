package br.com.jr.aoe.technology.build.logic.generic

import br.com.jr.aoe.technology.build.logic.extensions.getLibrary
import org.gradle.api.Project

fun installCommonDependencies(target: Project) {
    target.dependencies.apply {
        add(
            "implementation",
            target.getLibrary(alias = "androidx-core-ktx")
        )
    }
    target.dependencies.apply {
        add(
            "implementation",
            target.getLibrary(alias = "androidx-lifecycle-runtime-ktx")
        )
    }
    target.dependencies.apply {
        add(
            "implementation",
            target.getLibrary(alias = "androidx-activity-compose")
        )
    }
    target.dependencies.apply {
        add(
            "implementation",
            target.getLibrary(alias = "androidx-compose-ui")
        )
    }
    target.dependencies.apply {
        add(
            "implementation",
            target.getLibrary(alias = "androidx-compose-ui-graphics")
        )
    }
    target.dependencies.apply {
        add(
            "implementation",
            target.getLibrary(alias = "androidx-compose-ui-tooling-preview")
        )
    }
    target.dependencies.apply {
        add(
            "debugImplementation",
            target.getLibrary(alias = "androidx-compose-ui-tooling")
        )
    }
    target.dependencies.apply {
        add(
            "debugImplementation",
            target.getLibrary(alias = "androidx-compose-ui-test-manifest")
        )
    }
}
