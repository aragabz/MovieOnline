package com.ragabz.movieonline.data.local.prefs

import android.content.SharedPreferences
import com.ragabz.movieonline.extensions.cacheString
import com.ragabz.movieonline.extensions.getCachedString
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager
@Inject constructor(
    private var sharedPreferences: SharedPreferences
) {

    companion object {
        const val PREF_NAME = "movie_app_prefs"
        const val PREFS_LAST_SYNC_TIME = "last_sync_time"
    }

    var lastSyncTime: String
        get() = sharedPreferences.getCachedString(PREFS_LAST_SYNC_TIME)
        set(value) = sharedPreferences.cacheString(PREFS_LAST_SYNC_TIME, value)
}
