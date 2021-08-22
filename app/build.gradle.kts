plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
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

    implementation(Libs.Ktx.CORE)
    implementation(Libs.Ktx.COLLECTION)
    implementation(Libs.Helper.APP_COMPAT)
    implementation(Libs.Helper.MATERIAL)
    implementation(Libs.Helper.CONSTRAINT_LAYOUT)
    implementation(Libs.Helper.LEGACY_SUPPORT)
    implementation(Libs.Lifecycle.LIVE_DATE)
    implementation(Libs.Lifecycle.VIEW_MODEL_KTX)
    implementation(Libs.Navigation.FRAGMENT_KTX)
    implementation(Libs.Navigation.UI_KTX)
    testImplementation(TestLibs.JUNIT)
    androidTestImplementation(TestLibs.TestAndroid.JUNIT)
    androidTestImplementation(TestLibs.TestAndroid.ESPRESSO)
    implementation(Libs.Helper.DATASTORE)
    implementation(Libs.Ktx.FRAGMENT)
}