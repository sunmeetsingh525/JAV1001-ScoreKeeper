package com.example.layouts_and_views

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager

class MainActivity : AppCompatActivity() {
    private var num1: Int = 0
    private var num2: Int = 0
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private var saveScores: Boolean = true

    @SuppressLint("ResourceType", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        editor = sharedPreferences.edit()

        val score = arrayOf("0", "1", "2", "3")
        val spinner1 = findViewById<Spinner>(R.id.result1)
        val spinner2 = findViewById<Spinner>(R.id.result2)
        val arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, score
        )
        spinner1.adapter = arrayAdapter
        spinner2.adapter = arrayAdapter

        val score1 = findViewById<TextView>(R.id.score1)
        val score2 = findViewById<TextView>(R.id.score2)

        val btn1_increase = findViewById<Button>(R.id.btn1_increase)
        val btn1_decrease = findViewById<Button>(R.id.btn1_decrease)
        val btn2_increase = findViewById<Button>(R.id.btn2_increase)
        val btn2_decrease = findViewById<Button>(R.id.btn2_decrease)

        btn1_increase.setOnClickListener {
            num1++
            score1.text = "$num1"
            saveScores()
        }

        btn1_decrease.setOnClickListener {
            num1--
            if (num1 < 0) {
                score1.text = "0"
                num1 = 0
            } else {
                score1.text = "$num1"
            }
            saveScores()
        }

        btn2_increase.setOnClickListener {
            num2++
            score2.text = "$num2"
            saveScores()
        }

        btn2_decrease.setOnClickListener {
            num2--
            if (num2 < 0) {
                score2.text = "0"
                num2 = 0
            } else {
                score2.text = "$num2"
            }
            saveScores()
        }

        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val positionVal = score[position]
                val valToInt = positionVal.toInt()
                val final1 = valToInt + num1
                num1 = final1
                score1.text = "$num1"
                saveScores()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val positionVal = score[position]
                val valToInt = positionVal.toInt()
                val final2 = valToInt + num2
                num2 = final2
                score2.text = "$num2"
                saveScores()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        num1 = sharedPreferences.getInt("score1", 0)
        num2 = sharedPreferences.getInt("score2", 0)
        score1.text = "$num1"
        score2.text = "$num2"
    }

    private fun saveScores() {
        if (saveScores) {
            editor.putInt("score1", num1)
            editor.putInt("score2", num2)
            editor.apply()
        }
    }

    override fun onResume() {
        super.onResume()
        saveScores = sharedPreferences.getBoolean("save_scores", true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_about -> {
                val developerInfo1 =
                    "Developer: Ruby Chaulagain \n Course Code: JAV-1001-50805"
                Toast.makeText(this, developerInfo1, Toast.LENGTH_LONG).show()
                val developerInfo2 =
                    "Developer: Sunmeet Singh \n Course Code: JAV-1001-50805"
                Toast.makeText(this, developerInfo2, Toast.LENGTH_LONG).show()
                return true
            }

            R.id.menu_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}
