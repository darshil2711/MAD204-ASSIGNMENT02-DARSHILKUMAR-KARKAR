/**
 * Course: MAD204-01
 * Name: Darshilkumar Karkar (A00203357)
 * Date: 23/11/2025
 * Description: Helper class to manage SharedPreferences data.
 */
package com.example.assignment2_yourname // UPDATE THIS

import android.content.Context
import android.content.SharedPreferences


class PrefsManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    private val editor = prefs.edit()

    fun saveString(key: String, value: String) {
        editor.putString(key, value).apply()
    }

    fun getString(key: String): String? {
        return prefs.getString(key, null)
    }

    fun saveBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Boolean {
        return prefs.getBoolean(key, false)
    }

    fun clearData() {
        editor.clear().apply()
    }
}