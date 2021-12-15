plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
    id("com.github.ben-manes.versions")
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
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
        }

        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            // base url:   https://tmdb.com/v3/
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
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
    // bundles
    implementation(libs.bundles.core)
    implementation(libs.bundles.kotlin)
    implementation(libs.bundles.navigation)
    implementation(libs.bundles.lifecycle)
    implementation(libs.bundles.network)
    implementation(libs.coroutinesAndroid)
    implementation(libs.bundles.test)
    // room database
    implementation(libs.bundles.room)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    kapt(libs.roomCompiler)

    // glide
    implementation(libs.glide)
    kapt(libs.glideCompiler)
    // hilt
    implementation(libs.hiltAndroid)
    kapt(libs.hiltCompiler)
    // timber
    implementation(libs.timber)

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.vectordrawable)
    implementation(libs.legacySupport)
    implementation(libs.cardview)
    implementation(libs.recyclerview)
    implementation(libs.constraintlayout)
    implementation(libs.preference)
    implementation(libs.materialDialogsCore)
    implementation(libs.startupRuntime)
    implementation(libs.activity)
    implementation(libs.fragmentKtx)
    debugImplementation(libs.chuckerDebug)
    implementation(libs.circularImageView)
    implementation(libs.threetenabp)
    implementation(libs.paging)
    implementation(libs.gson)
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
    implementation("androidx.multidex:multidex:2.0.1")
    implementation("com.github.florent37:glidepalette:2.1.2")
    implementation("com.github.chrisbanes:PhotoView:2.3.0")
}
