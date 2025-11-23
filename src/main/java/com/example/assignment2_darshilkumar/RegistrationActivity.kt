package com.example.assignment2_darshilkumar

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Handles user registration, validates input, and saves details to SharedPreferences.
 */
class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val etFullName = findViewById<EditText>(R.id.etFullName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etAge = findViewById<EditText>(R.id.etAge)
        val etProgram = findViewById<EditText>(R.id.etProgram)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val name = etFullName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val ageStr = etAge.text.toString().trim()
            val program = etProgram.text.toString().trim()

            if (validateInput(name, email, ageStr, program)) {
                // Use PrefsManager to save the user details
                PrefsManager.saveUser(this, name, email, ageStr, program)
                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
                finish() // Go back to the previous screen (Login)
            }
        }
    }

    /**
     * Validates the registration form fields.
     * @return True if all fields are valid, false otherwise.
     */
    private fun validateInput(name: String, email: String, ageStr: String, program: String): Boolean {
        if (name.isEmpty() || email.isEmpty() || ageStr.isEmpty() || program.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            return false
        }
        val age = ageStr.toIntOrNull()
        if (age == null || age <= 0) {
            Toast.makeText(this, "Age must be a positive number", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}
