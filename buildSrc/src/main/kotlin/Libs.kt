object Libs {


    object Helper {
        const val APP_COMPAT = "androidx.appcompat:appcompat:1.3.1"
        const val MATERIAL = "com.google.android.material:material:1.4.0"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.1.0"
        const val LEGACY_SUPPORT = "androidx.legacy:legacy-support-v4:1.0.0"
        const val DATASTORE = "androidx.datastore:datastore:1.0.0"
    }

    object Ktx {
        const val CORE = "androidx.core:core-ktx:1.6.0"
        const val FRAGMENT = "androidx.fragment:fragment-ktx:1.3.6"
        const val COLLECTION =  "androidx.collection:collection-ktx:${Versions.COLLECTION_KTX}"
    }

    object Lifecycle {
        const val LIVE_DATE = "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"
        const val VIEW_MODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"

    }

    object Navigation {
        const val FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:2.3.5"
        const val UI_KTX = "androidx.navigation:navigation-ui-ktx:2.3.5"
    }
}

object TestLbs {

    const val JUNIT = "junit:junit:4.13.2"

    object TestAndroid {
        const val JUNIT = "androidx.test.ext:junit:1.1.3"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:3.4.0"

    }
}