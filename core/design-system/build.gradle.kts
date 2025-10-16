import br.com.jr.aoe.technology.build.logic.namespace.NameSpace

plugins {
    id(id = "br.com.jr.aoe.technology.library")
}

apply(from = "${project.rootDir}/config/detekt/detekt.gradle")

android {
    namespace = NameSpace.CORE_DESIGN_SYSTEM
}

dependencies {
    implementation(dependencyNotation = platform(libs.androidx.compose.bom))
    implementation(dependencyNotation = libs.androidx.compose.material3)
}
