package com.example.assignment2_darshilkumar

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// REMOVED: import androidx.compose.ui.semantics.setText (This was the error)

/**
 * Course: F2025 MAD204-01 Java Development for MA
 * Assignment: 2
 * Student Name: Darshilkumar Karkar
 * Description: Displays user profile details, allows editing, and logs lifecycle events.
 */
class ProfileActivity : AppCompatActivity() {

    private val TAG = "ProfileLifecycle"
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etAge: EditText
    private lateinit var etProgram: EditText
    private lateinit var btnEdit: Button
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        Log.d(TAG, "onCreate called")

        // Initialize views from the layout - These IDs are correct.
        etName = findViewById(R.id.etProfileName)
        etEmail = findViewById(R.id.etProfileEmail)
        etAge = findViewById(R.id.etProfileAge)
        etProgram = findViewById(R.id.etProfileProgram)
        btnEdit = findViewById(R.id.btnEditProfile)
        btnSave = findViewById(R.id.btnSaveChanges)

        // Load data from PrefsManager and populate fields
        loadProfileData()

        // Set button listeners
        btnEdit.setOnClickListener {
            enableEditing(true)
        }

        btnSave.setOnClickListener {
            saveProfileChanges()
            enableEditing(false)
        }
    }

    /**
     * Loads user data from PrefsManager and displays it in the EditText fields.
     */
    private fun loadProfileData() {
        // These keys are correct and match PrefsManager
        etName.setText(PrefsManager.getName(this))
        etEmail.setText(PrefsManager.getEmail(this))
        etAge.setText(PrefsManager.getAge(this))
        etProgram.setText(PrefsManager.getProgram(this))
    }

    /**
     * Toggles the UI between view mode and edit mode.
     * @param isEnabled True to enable editing, false to disable it.
     */
    private fun enableEditing(isEnabled: Boolean) {
        // Name, Age, and Program are editable. Email is a unique ID and should not be.
        etName.isEnabled = isEnabled
        etAge.isEnabled = isEnabled
        etProgram.isEnabled = isEnabled

        if (isEnabled) {
            // In Edit Mode: Hide "Edit", show "Save"
            btnEdit.visibility = View.GONE
            btnSave.visibility = View.VISIBLE
            etName.requestFocus() // Set focus to the first editable field
        } else {
            // In View Mode: Show "Edit", hide "Save"
            btnEdit.visibility = View.VISIBLE
            btnSave.visibility = View.GONE
        }
    }

    /**
     * Saves the updated profile data back to SharedPreferences using PrefsManager.
     */
    private fun saveProfileChanges() {
        val newName = etName.text.toString().trim()
        val newEmail = etEmail.text.toString().trim() // Even though it's not editable, we get the value
        val newAge = etAge.text.toString().trim()
        val newProgram = etProgram.text.toString().trim()

        // Use the existing saveUser function to update all details
        PrefsManager.saveUser(this, newName, newEmail, newAge, newProgram)

        Toast.makeText(this, "Profile Updated!", Toast.LENGTH_SHORT).show()
    }

    // --- Lifecycle Logging Methods ---
    override fun onStart() { super.onStart(); Log.d(TAG, "onStart called") }
    override fun onResume() { super.onResume(); Log.d(TAG, "onResume called") }
    override fun onPause() { super.onPause(); Log.d(TAG, "onPause called") }
    override fun onStop() { super.onStop(); Log.d(TAG, "onStop called") }
    override fun onDestroy() { super.onDestroy(); Log.d(TAG, "onDestroy called") }
}
