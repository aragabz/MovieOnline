plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")

}

android {
    compileSdk = AppConfig.COMPILE_SDK

    defaultConfig {
        applicationId = AppConfig.APPLICATION_ID
        minSdk = AppConfig.MIN_SDK
        targetSdk = AppConfig.TARGET_SDK
        versionCode = AppConfig.VERSION_CODE
        versionName = AppConfig.VERSION_NAME

        testInstrumentationRunner = AppConfig.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.Helper.KOTLIN_STDLIB)

    implementation(Libs.Helper.APP_COMPAT)
    implementation(Libs.Helper.MATERIAL)
    implementation(Libs.Helper.CONSTRAINT_LAYOUT)
    implementation(Libs.Helper.LEGACY_SUPPORT)
    implementation(Libs.Helper.DATASTORE)

    implementation(Libs.Ktx.CORE_KTX)
    implementation(Libs.Ktx.COLLECTION_KTX)
    implementation(Libs.Ktx.FRAGMENT_KTX)
    implementation(Libs.Ktx.ACTIVITY_KTX)

    implementation(Libs.Lifecycle.LIFECYCLE_LIVE_DATE)
    implementation(Libs.Lifecycle.LIFECYCLE_VIEW_MODEL_KTX)

    implementation(Libs.Navigation.NAVIGATION_FRAGMENT_KTX)
    implementation(Libs.Navigation.NAVIGATION_UI_KTX)

    implementation(Libs.DI.HILT_ANDROID)
    kapt(Libs.DI.HILT_COMPILER)


    testImplementation(TestLibs.JUNIT)
    androidTestImplementation(TestLibs.TestAndroid.JUNIT)
    androidTestImplementation(TestLibs.TestAndroid.ESPRESSO)
}