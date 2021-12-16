package com.ragabz.movieonline.extensions

import android.content.SharedPreferences

fun SharedPreferences.cacheBoolean(k: String, v: Boolean) {
    edit().putBoolean(k, v).apply()
}

fun SharedPreferences.getCachedBoolean(k: String, defaultValue: Boolean): Boolean {
    return getBoolean(k, defaultValue)
}

fun SharedPreferences.cacheInt(k: String, v: Int) {
    edit().putInt(k, v).apply()
}

fun SharedPreferences.getCachedInt(k: String): Int {
    return getInt(k, -1)
}

fun SharedPreferences.cacheString(key: String, value: String) {
    edit().putString(key, value).apply()
}

fun SharedPreferences.getCachedString(key: String): String {
    return getString(key, "") ?: ""
}

fun SharedPreferences.getCachedString(key: String, defaultValue: String): String {
    return getString(key, defaultValue) ?: ""
}

fun SharedPreferences.cacheLong(k: String, v: Long) {
    edit().putLong(k, v).apply()
}

fun SharedPreferences.getCachedLong(k: String): Long {
    return getLong(k, -1)
}
