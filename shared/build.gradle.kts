import org.jetbrains.kotlin.gradle.plugin.sources.dependsOnClosure

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.animation)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.androidx.lifecycle.viewmodel.compose)
            implementation(libs.androidx.navigation.compose)
            implementation(libs.androidx.viewmodel)

            //implementation(libs.koin.core)
            //implementation(libs.koin.compose)
        }

        commonTest {
            dependencies {
                //implementation(libs.koin.test)
                implementation(libs.kotlin.test)
            }
        }

        androidMain {
            dependencies {}
        }

        iosMain {
            dependsOn(commonMain.get())
            dependencies { }
            iosX64 { dependsOn(this@iosMain) }
            iosArm64{ dependsOn(this@iosMain) }
            iosSimulatorArm64 { dependsOn(this@iosMain) }
        }
    }
}

android {
    namespace = "com.example.kmp_example"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
