// In onCreate:
val prefs = PrefsManager(this)

// Auto-login check
if (prefs.getString("IS_LOGGED_IN") == "true") {
    startActivity(Intent(this, DashboardActivity::class.java))
    finish()
}

btnLogin.setOnClickListener {
    val email = etEmail.text.toString()
    val password = etPassword.text.toString()

    if (!email.contains("@") || password.length < 4) {
        // Show error
    } else {
        prefs.saveString("USER_EMAIL", email) // Save current login
        prefs.saveString("IS_LOGGED_IN", "true")
        startActivity(Intent(this, DashboardActivity::class.java))
    }
}

btnGoRegister.setOnClickListener {
    startActivity(Intent(this, RegistrationActivity::class.java))
}