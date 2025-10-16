import br.com.jr.aoe.technology.build.logic.namespace.NameSpace

plugins {
    id(id = "br.com.jr.aoe.technology.library")
    alias(notation = libs.plugins.jetbrains.kotlin.serialization)
}

apply(from = "${project.rootDir}/config/detekt/detekt.gradle")

android {
    namespace = NameSpace.FEATURE_ACCOUNT
}

dependencies {
    implementation(dependencyNotation = libs.kotlinx.serialization.json)
    implementation(dependencyNotation = platform(libs.androidx.compose.bom))
    implementation(dependencyNotation = libs.androidx.compose.material3)
}
