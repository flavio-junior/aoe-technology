import br.com.jr.aoe.technology.build.logic.modules.Modules
import br.com.jr.aoe.technology.build.logic.namespace.NameSpace

plugins {
    id(id = "br.com.jr.aoe.technology.library")
}

apply(from = "${project.rootDir}/config/detekt/detekt.gradle")

android {
    namespace = NameSpace.FEATURE_UI_SHARED
}

dependencies {
    implementation(dependencyNotation = platform(libs.androidx.compose.bom))
    implementation(dependencyNotation = libs.androidx.compose.material3)
    implementation(dependencyNotation = libs.koin.androidx.compose)
    implementation(dependencyNotation = libs.androidx.navigation.compose)
    implementation(dependencyNotation = project(path = Modules.CORE_DESIGN_SYSTEM))
    implementation(dependencyNotation = project(path = Modules.CORE_NAVIGATION))
    implementation(dependencyNotation = project(path = Modules.CORE_NETWORK))
}
