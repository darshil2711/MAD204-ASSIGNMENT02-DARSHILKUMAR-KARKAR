package com.example.assignment2_darshilkumar

import android.content.Context
import android.content.SharedPreferences

object PrefsManager {    private const val PREFS_NAME = "user_prefs"
    private const val KEY_IS_LOGGED_IN = "is_logged_in"
    private const val KEY_EMAIL = "email"
    private const val KEY_NAME = "name"
    private const val KEY_PROGRAM = "program"
    private const val KEY_AGE = "age"

    // --- New Keys for Settings ---
    private const val KEY_DARK_MODE = "dark_mode"
    private const val KEY_NOTIFICATIONS = "notifications_enabled"

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    // --- User Data Functions ---
    fun saveUser(context: Context, name: String, email: String, age: String, program: String) {
        val editor = getPreferences(context).edit()
        editor.putString(KEY_NAME, name)
        editor.putString(KEY_EMAIL, email)
        editor.putString(KEY_AGE, age)
        editor.putString(KEY_PROGRAM, program)
        editor.apply()
    }

    fun setLoggedIn(context: Context, loggedIn: Boolean) {
        val editor = getPreferences(context).edit()
        editor.putBoolean(KEY_IS_LOGGED_IN, loggedIn)
        editor.apply()
    }

    fun isLoggedIn(context: Context): Boolean {
        return getPreferences(context).getBoolean(KEY_IS_LOGGED_IN, false)
    }

    fun getName(context: Context): String? = getPreferences(context).getString(KEY_NAME, "User")
    fun getEmail(context: Context): String? = getPreferences(context).getString(KEY_EMAIL, "")
    fun getAge(context: Context): String? = getPreferences(context).getString(KEY_AGE, "")
    fun getProgram(context: Context): String? = getPreferences(context).getString(KEY_PROGRAM, "")

    // --- FIXED: ADDING THE MISSING SETTINGS FUNCTIONS ---

    /**
     * Sets the dark mode preference.
     */
    fun setDarkMode(context: Context, isEnabled: Boolean) {
        val editor = getPreferences(context).edit()
        editor.putBoolean(KEY_DARK_MODE, isEnabled)
        editor.apply()
    }

    /**
     * Checks if dark mode is enabled.
     */
    fun isDarkMode(context: Context): Boolean {
        return getPreferences(context).getBoolean(KEY_DARK_MODE, false)
    }

    /**
     * Sets the notifications preference.
     */
    fun setNotifications(context: Context, isEnabled: Boolean) {
        val editor = getPreferences(context).edit()
        editor.putBoolean(KEY_NOTIFICATIONS, isEnabled)
        editor.apply()
    }

    /**
     * Checks if notifications are enabled.
     */
    fun areNotificationsEnabled(context: Context): Boolean {
        return getPreferences(context).getBoolean(KEY_NOTIFICATIONS, false)
    }

    fun clearSession(context: Context) {
        val editor = getPreferences(context).edit()
        // Note: We only clear user data, not settings like dark mode.
        editor.remove(KEY_NAME)
        editor.remove(KEY_EMAIL)
        editor.remove(KEY_AGE)
        editor.remove(KEY_PROGRAM)
        editor.remove(KEY_IS_LOGGED_IN)
        editor.apply()
    }
}
