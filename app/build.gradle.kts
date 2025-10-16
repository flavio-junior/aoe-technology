import br.com.jr.aoe.technology.build.logic.modules.Modules

plugins {
    id(id = "br.com.jr.aoe.technology.application")
    alias(notation = libs.plugins.jetbrains.kotlin.serialization)
}

apply(from = "${project.rootDir}/config/detekt/detekt.gradle")

dependencies {
    implementation(dependencyNotation = platform(libs.androidx.compose.bom))
    implementation(dependencyNotation = libs.androidx.compose.material3)
    implementation(dependencyNotation = libs.koin.androidx.compose)
    implementation(dependencyNotation = libs.kotlinx.serialization.json)
    implementation(dependencyNotation = libs.androidx.navigation.compose)
    implementation(dependencyNotation = libs.bundles.retrofit)
    implementation(dependencyNotation = project(path = Modules.CORE_DESIGN_SYSTEM))
    implementation(dependencyNotation = project(path = Modules.CORE_NAVIGATION))
    implementation(dependencyNotation = project(path = Modules.FEATURE_ACCOUNT))
    implementation(dependencyNotation = project(path = Modules.FEATURE_ACCOUNT))
    implementation(dependencyNotation = project(path = Modules.FEATURE_PAYMENT))
    implementation(dependencyNotation = project(path = Modules.FEATURE_UI_SHARED))
    testImplementation(dependencyNotation = libs.junit)
    androidTestImplementation(dependencyNotation = libs.androidx.junit)
    androidTestImplementation(dependencyNotation = libs.androidx.espresso.core)
    androidTestImplementation(dependencyNotation = platform(libs.androidx.compose.bom))
    androidTestImplementation(dependencyNotation = libs.androidx.compose.ui.test.junit4)
    debugImplementation(dependencyNotation = libs.androidx.compose.ui.tooling)
    debugImplementation(dependencyNotation = libs.androidx.compose.ui.test.manifest)
}
