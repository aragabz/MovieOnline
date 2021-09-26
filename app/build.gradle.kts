plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
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
            // base url:   https://tmdb.com/v3/
            buildConfigField( "String","BASE_URL", "\"https://api.themoviedb.org/3/\"" )
        }

        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            // base url:   https://tmdb.com/v3/
            buildConfigField( "String","BASE_URL", "\"https://api.themoviedb.org/3/\"" )
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
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    kapt(Libs.DI.HILT_COMPILER)


    testImplementation(TestLibs.JUNIT)
    androidTestImplementation(TestLibs.TestAndroid.JUNIT)
    androidTestImplementation(TestLibs.TestAndroid.ESPRESSO)

    implementation(Libs.Helper.retrofit)
    implementation(Libs.Helper.retrofitConverterGson)
    implementation(Libs.Helper.OKHTTP)
    implementation(Libs.Helper.OKHTTP_LOGGING_INTERCEPTOR)

    val room_version = "2.3.0"
    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
    // timber logging
    implementation(Libs.Helper.TIMBER)

    implementation(Libs.Helper.GLIDE)
    kapt(Libs.Helper.GLIDE_COMPILER)

    debugImplementation ("com.github.chuckerteam.chucker:library:3.5.2")
    releaseImplementation ("com.github.chuckerteam.chucker:library-no-op:3.5.2")
}