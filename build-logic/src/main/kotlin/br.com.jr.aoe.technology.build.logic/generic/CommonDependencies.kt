package br.com.jr.aoe.technology.build.logic.generic

import br.com.jr.aoe.technology.build.logic.extensions.getLibrary
import br.com.jr.aoe.technology.build.logic.libraries.allLibraries
import br.com.jr.aoe.technology.build.logic.libraries.androidTestImplementation
import br.com.jr.aoe.technology.build.logic.libraries.debugLibraries
import org.gradle.api.Project

fun installCommonDependencies(target: Project) {
    allLibraries.forEach {
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
    target.dependencies.add(
        "testImplementation",
        target.getLibrary(alias = "junit")
    )
    androidTestImplementation.forEach {
        target.dependencies.add(
            "androidTestImplementation",
            target.getLibrary(alias = it)
        )
    }
}
