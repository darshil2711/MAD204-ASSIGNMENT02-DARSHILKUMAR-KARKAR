/*
 * Course: MAD204
 * Student Name: Darshilkumar Karkar
 * Student ID: A00203357
 * Submission Date: 2025-11-23
 * Description: Login screen with validation and persistence check.
 */
package com.example.assignment2_darshilkumar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Check persistence first: if already logged in, go to Dashboard
        if (PrefsManager.isLoggedIn(this)) {
            startActivity(Intent(this, DashboardActivity::class.java))
            finish() // Close this activity so the user can't go back to it
            return   // Exit onCreate early
        }

        // If not logged in, show the login layout
        setContentView(R.layout.activity_main)

        val etEmail = findViewById<EditText>(R.id.etLoginEmail)
        val etPassword = findViewById<EditText>(R.id.etLoginPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegister = findViewById<Button>(R.id.btnGoToRegister)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // Assignment Validation: Email must contain "@", Password >= 4 characters.
            if (!email.contains("@")) {
                Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.length < 4) {
                Toast.makeText(this, "Password must be at least 4 characters", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            // Mark user as logged in after a successful login attempt.
            val editor = getSharedPreferences("user_prefs", MODE_PRIVATE).edit()
            editor.putBoolean("is_logged_in", true)
            editor.apply()


            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }

        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
    }
}
