package com.example.moja_aplikacja.utils

import android.content.Context
import android.content.SharedPreferences

object AuthPreferences {
    private const val PREF_NAME = "auth_prefs"
    private const val KEY_LOGGED_IN = "is_logged_in"

    fun setLoggedIn(context: Context, value: Boolean) {
        val prefs: SharedPreferences =
            context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        prefs.edit().putBoolean(KEY_LOGGED_IN, value).apply()
    }

    fun isLoggedIn(context: Context): Boolean {
        val prefs: SharedPreferences =
            context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return prefs.getBoolean(KEY_LOGGED_IN, false)
    }
}
