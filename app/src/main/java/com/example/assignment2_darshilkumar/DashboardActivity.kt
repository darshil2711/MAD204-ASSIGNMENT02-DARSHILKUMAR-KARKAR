class DashboardActivity : AppCompatActivity() {
    private val TAG = "DashboardActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        Log.d(TAG, "onCreate called")

        val prefs = PrefsManager(this)
        val welcomeText = findViewById<TextView>(R.id.tvWelcome)
        welcomeText.text = "Welcome, ${prefs.getString("USER_NAME")}"

        findViewById<Button>(R.id.btnLogout).setOnClickListener {
            prefs.clearData() // Or just remove IS_LOGGED_IN
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        // Setup other button listeners to navigate to other activities
    }

    override fun onStart() { super.onStart(); Log.d(TAG, "onStart called") }
    override fun onResume() { super.onResume(); Log.d(TAG, "onResume called") }
    // Implement onPause, onStop, onDestroy similarly
}