// In onCreate:
val btnRegister = findViewById<Button>(R.id.btnRegister)
val etName = findViewById<EditText>(R.id.etName)
val etAge = findViewById<EditText>(R.id.etAge)
val etEmail = findViewById<EditText>(R.id.etRegEmail)
// Add other fields...

btnRegister.setOnClickListener {
    val name = etName.text.toString()
    val age = etAge.text.toString().toIntOrNull() ?: 0

    if (name.isEmpty() || age <= 0) {
        Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show()
    } else {
        val prefs = PrefsManager(this)
        prefs.saveString("USER_NAME", name)
        prefs.saveString("USER_EMAIL", etEmail.text.toString())
        Toast.makeText(this, "Registered!", Toast.LENGTH_SHORT).show()
        finish() // Go back to login
    }
}