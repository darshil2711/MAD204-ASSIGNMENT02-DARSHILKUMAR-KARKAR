/*
 * Course: MAD204
 * Description: Settings screen for user preferences.
 */
package com.example.assignment2_darshilkumar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.switchmaterial.SwitchMaterial

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Use SwitchMaterial for better theming support
        val switchDark = findViewById<SwitchMaterial>(R.id.switchDarkMode)
        val switchNotif = findViewById<SwitchMaterial>(R.id.switchNotifications)

        // Load saved state from PrefsManager
        switchDark.isChecked = PrefsManager.isDarkMode(this)
        switchNotif.isChecked = PrefsManager.areNotificationsEnabled(this)

        // Listener for Dark Mode switch
        switchDark.setOnCheckedChangeListener { _, isChecked ->
            // 1. Save the preference
            PrefsManager.setDarkMode(this, isChecked)
            // 2. Apply the theme change immediately
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        // Listener for Notifications switch
        switchNotif.setOnCheckedChangeListener { _, isChecked ->
            PrefsManager.setNotifications(this, isChecked)
        }
    }
}
