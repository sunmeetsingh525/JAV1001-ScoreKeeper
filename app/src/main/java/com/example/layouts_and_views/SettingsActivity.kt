package com.example.layouts_and_views

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val switchSaveScores = findViewById<Switch>(R.id.switch_save_scores)

        // Retrieve the shared preferences
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = sharedPreferences.edit()

        // Get the current value of the switch
        val currentSetting = sharedPreferences.getBoolean("save_scores", true)
        switchSaveScores.isChecked = currentSetting

        // Set the listener for the switch
        switchSaveScores.setOnCheckedChangeListener { _, isChecked ->
            // Save the user's choice in shared preferences
            editor.putBoolean("save_scores", isChecked)
            editor.apply()
        }
    }
}
