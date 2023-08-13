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

        val switchSaveScores = findViewById<Switch>(R.id.switchSaveScores)
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        switchSaveScores.isChecked = sharedPreferences.getBoolean("save_scores", true)

        switchSaveScores.setOnCheckedChangeListener { _, isChecked ->
            editor.putBoolean("save_scores", isChecked)
            editor.apply()
        }
    }
}
