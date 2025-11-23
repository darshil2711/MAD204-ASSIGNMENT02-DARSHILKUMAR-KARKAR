package com.example.assignment2_darshilkumar

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * The main hub of the application after login. Displays a welcome message
 * and provides navigation to other screens. Also logs lifecycle methods.
 */
class DashboardActivity : AppCompatActivity() {

    private val TAG = "DashboardLifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        Log.d(TAG, "onCreate called")

        // Initialize views
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val btnNavProfile = findViewById<Button>(R.id.btnNavProfile)
        val btnNavList = findViewById<Button>(R.id.btnNavList)
        val btnNavSettings = findViewById<Button>(R.id.btnNavSettings)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // Set welcome message from PrefsManager
        // This will be updated in onResume as well, in case the name changes in ProfileActivity
        tvWelcome.text = "Welcome, ${PrefsManager.getName(this)}"

        // --- FIXED: ADDING THE MISSING NAVIGATION LOGIC ---

        // Navigate to ProfileActivity
        btnNavProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        // Navigate to ListActivity
        btnNavList.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }

        // Navigate to SettingsActivity
        btnNavSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        // --- Handle Logout ---
        btnLogout.setOnClickListener {
            // Use PrefsManager to clear only the session data, keeping settings
            PrefsManager.clearSession(this)

            val intent = Intent(this, MainActivity::class.java)
            // Flags to clear the back stack and start fresh at the login screen
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish() // Ensure this activity is closed
        }
    }

    /**
     * Called when the activity is about to become visible.
     * We update the welcome message here in case the user edited their name in ProfileActivity.
     */
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
        // Refresh the welcome message
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        tvWelcome.text = "Welcome, ${PrefsManager.getName(this)}"
    }

    // --- Other Lifecycle Logging Methods ---
    override fun onStart() { super.onStart(); Log.d(TAG, "onStart called") }
    override fun onPause() { super.onPause(); Log.d(TAG, "onPause called") }
    override fun onStop() { super.onStop(); Log.d(TAG, "onStop called") }
    override fun onDestroy() { super.onDestroy(); Log.d(TAG, "onDestroy called") }
}
