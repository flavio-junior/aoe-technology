import br.com.jr.aoe.technology.build.logic.modules.Modules
import br.com.jr.aoe.technology.build.logic.namespace.NameSpace
import java.util.Properties

plugins {
    id(id = "br.com.jr.aoe.technology.library")
}

apply(from = "${project.rootDir}/config/detekt/detekt.gradle")

android {
    namespace = NameSpace.CORE_NETWORK

    buildTypes {
        debug {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            val proprieties = Properties()
            proprieties.load(project.rootProject.file("local.properties").inputStream())
            buildConfigField(
                type = "String",
                name = "URL_API",
                value = "\"${proprieties.getProperty("URL_API_DEV")}\""
            )
        }

        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            val proprieties = Properties()
            proprieties.load(project.rootProject.file("local.properties").inputStream())
            buildConfigField(
                type = "String",
                name = "URL_API",
                value = "\"${proprieties.getProperty("URL_API_PROD")}\""
            )
        }
    }
}

dependencies {
    implementation(dependencyNotation = platform(libs.androidx.compose.bom))
    implementation(dependencyNotation = libs.androidx.compose.material3)
    implementation(dependencyNotation = libs.androidx.datastore.preferences)
    implementation(dependencyNotation = libs.koin.androidx.compose)
    implementation(dependencyNotation = libs.bundles.retrofit)
    implementation(dependencyNotation = project(path = Modules.CORE_CRYPTOGRAPHY))
    implementation(dependencyNotation = project(path = Modules.CORE_COMMON))
}
