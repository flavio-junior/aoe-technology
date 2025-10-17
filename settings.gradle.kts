pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AOE TECHNOLOGY"
include(":app")
include(":core:cryptography")
include(":core:common")
include(":core:design-system")
include(":core:navigation")
include(":core:network")
include(":feature:account")
include(":feature:payment")
include(":feature:ui-shared")
