package com.ragabz.movieonline

import android.app.Application
import dagger.Component
import dagger.Module
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import timber.log.Timber

@HiltAndroidApp
class MovieApp: Application() {

    override fun onCreate() {
        super.onCreate()
        // init timber
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }


}
