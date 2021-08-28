object Libs {

    /**
     * Helpers and 3d party lib
     */
    object Helper {
        const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.21"
        const val APP_COMPAT = "androidx.appcompat:appcompat:1.3.1"
        const val MATERIAL = "com.google.android.material:material:1.4.0"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.1.0"
        const val LEGACY_SUPPORT = "androidx.legacy:legacy-support-v4:1.0.0"
        const val TIMBER = "com.jakewharton.timber:timber:${Versions.timber}"
        const val VIEWPAGER2 = "androidx.viewpager2:viewpager2:${Versions.viewpager2}"
        const val SLIDING_PANE_LAYOUT =
            "androidx.slidingpanelayout:slidingpanelayout:${Versions.slidingpanelayout}"

        // okhttp
        const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        const val OKHTTP_LOGGING_INTERCEPTOR =
            "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

        // okio
        const val OKIO = "com.squareup.okio:okio:${Versions.okio}"

        // lottie
        const val LOTTIE = "com.airbnb.android:lottie:${Versions.lottie}"

        const val GSON = "com.google.code.gson:gson:${Versions.gson}"
        const val HAMCREST = "org.hamcrest:hamcrest-library:${Versions.hamcrest}"

        // glide
        const val GLIDE = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${Versions.glide}"

        // fragment test
        const val FRAGMENT_TEST = "androidx.fragment:fragment-testing:${Versions.fragment}"

        // drawer layout
        const val DRAWER_LAYOUT = "androidx.drawerlayout:drawerlayout:${Versions.drawerLayout}"

        // data store
        const val DATASTORE = "androidx.datastore:datastore:1.0.0"
        const val DATA_STORE_PREFERENCES =
            "androidx.datastore:datastore-preferences:${Versions.dataStore}"

        // coroutines
        const val COROUTINES =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val COROUTINES_TEST =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"

        // card view
        const val CARDVIEW = "androidx.cardview:cardview:${Versions.cardview}"

        // benchmark
        const val BENCHMARK = "androidx.benchmark:benchmark-junit4:${Versions.benchmark}"
        const val BENCHMARK_MACRO =
            "androidx.benchmark:benchmark-macro-junit4:${Versions.benchmarkMacro}"

        // browser
        const val BROWSER = "androidx.browser:browser:${Versions.browser}"

        // app startup
        const val APP_STARTUP = "androidx.startup:startup-runtime:${Versions.appStartup}"
    }

    /**
     * ktx [ core, fragment, activity, collection]
     *
     */
    object Ktx {
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.core}"
        const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.fragment}"
        const val COLLECTION_KTX = "androidx.collection:collection-ktx:${Versions.collectionKtx}"
        const val ACTIVITY_KTX = "androidx.activity:activity-ktx:${Versions.activity}"
    }

    /**
     * lifecycle
     */
    object Lifecycle {
        const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
        const val LIFECYCLE_COMPILER = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
        const val LIFECYCLE_LIVE_DATE =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
        const val LIFECYCLE_VIEW_MODEL_KTX =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val LIFECYCLE_RUNTIME_KTX =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    }

    /**
     * navigation
     */
    object Navigation {
        const val NAVIGATION_FRAGMENT_KTX =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    /**
     * Room for database
     */
    object Room {
        const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.room}"
        const val ROOM_KTX = "androidx.room:room-ktx:${Versions.room}"
        const val ROOM_RUNTIME = "androidx.room:room-runtime:${Versions.room}"
    }


    /**
     * dependency injection
     */
    object DI {
        const val HILT_ANDROID = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
        const val HILT_TESTING = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
    }

    /**
     * Firebase
     */
    object Firebase {
        const val FIREBASE_ANALYTICS =
            "com.google.firebase:firebase-analytics-ktx:${Versions.firebaseAnalytics}"
        const val FIREBASE_AUTH = "com.google.firebase:firebase-auth-ktx:${Versions.firebaseAuth}"
        const val FIREBASE_CONFIG =
            "com.google.firebase:firebase-config-ktx:${Versions.firebaseConfig}"
        const val FIREBASE_FIRESTORE =
            "com.google.firebase:firebase-firestore-ktx:${Versions.lifecycle}"
        const val FIREBASE_FUNCTIONS =
            "com.google.firebase:firebase-functions-ktx:${Versions.lifecycle}"
        const val FIREBASE_MESSAGING =
            "com.google.firebase:firebase-messaging:${Versions.lifecycle}"
        const val FIREBASE_UI_AUTH = "com.firebaseui:firebase-ui-auth:${Versions.lifecycle}"
        const val FIREBASE_CRASHLYTICS =
            "com.google.firebase:firebase-crashlytics:${Versions.lifecycle}"
    }
}

object TestLibs {

    const val JUNIT = "junit:junit:${Versions.junit}"

    object TestAndroid {
        const val JUNIT = "androidx.test.ext:junit:${Versions.junitExt}"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    }
}