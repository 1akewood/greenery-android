package com.hyunday.greenery_android

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences(context: Context, key: String) {
    val PREFS_FILENAME = "Prefs"
    val PREF_KEY = key
    val sharedpref: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)

    var pref: String?
        get() = sharedpref.getString(PREF_KEY, "")
        set(value) = sharedpref.edit().putString(PREF_KEY, value).apply()
}