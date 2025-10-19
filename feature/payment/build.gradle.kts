import br.com.jr.aoe.technology.build.logic.modules.Modules
import br.com.jr.aoe.technology.build.logic.namespace.NameSpace

plugins {
    id(id = "br.com.jr.aoe.technology.library")
    id(id = "com.google.devtools.ksp")
    alias(notation = libs.plugins.jetbrains.kotlin.serialization)
}

apply(from = "${project.rootDir}/config/detekt/detekt.gradle")

android {
    namespace = NameSpace.FEATURE_PAYMENT
}

dependencies {
    implementation(dependencyNotation = libs.androidx.room.runtime)
    ksp(dependencyNotation = libs.androidx.room.compiler)
    implementation(dependencyNotation = libs.androidx.room.ktx)
    implementation(dependencyNotation = libs.kotlinx.serialization.json)
    implementation(dependencyNotation = platform(libs.androidx.compose.bom))
    implementation(dependencyNotation = libs.androidx.compose.material3)
    implementation(dependencyNotation = libs.koin.androidx.compose)
    implementation(dependencyNotation = libs.bundles.retrofit)
    implementation(dependencyNotation = libs.androidx.navigation.compose)
    implementation(dependencyNotation = libs.kotlinx.serialization.json)
    implementation(dependencyNotation = project(path = Modules.CORE_DESIGN_SYSTEM))
    implementation(dependencyNotation = project(path = Modules.CORE_NAVIGATION))
    implementation(dependencyNotation = project(path = Modules.CORE_NETWORK))
}
