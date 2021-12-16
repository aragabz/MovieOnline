package com.ragabz.movieonline.di

import android.content.Context
import android.content.SharedPreferences
import com.ragabz.movieonline.data.local.prefs.DataManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {
    /**
     * Provide shared preference
     *
     * @param context
     * @return
     */
    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(
            DataManager.PREF_NAME,
            Context.MODE_PRIVATE
        )
    }

    /**
     * Provide session manager
     *
     * @param sharedPreferences
     * @return
     */

    @Singleton
    @Provides
    fun provideSessionManager(sharedPreferences: SharedPreferences): DataManager {
        return DataManager(sharedPreferences)
    }
}
