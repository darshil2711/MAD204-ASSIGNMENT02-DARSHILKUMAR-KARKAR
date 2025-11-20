switchDarkMode.isChecked = prefs.getBoolean("DARK_MODE")
switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
    prefs.saveBoolean("DARK_MODE", isChecked)
    if(isChecked) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
}