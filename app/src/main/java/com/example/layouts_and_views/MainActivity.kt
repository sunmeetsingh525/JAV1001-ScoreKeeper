package com.example.layouts_and_views
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var num1: Int = 0
    var num2: Int = 0

    @SuppressLint("ResourceType", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Create array of basketball points
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


        //Increase score if first score(+) is clicked
        val btn1_increase = findViewById<Button>(R.id.btn1_increase)
        btn1_increase.setOnClickListener {
            num1++
            score1.setText("$num1")
        }

        //Decrease score if first score(-) is clicked
        val btn1_decrease = findViewById<Button>(R.id.btn1_decrease)
        btn1_decrease.setOnClickListener {
            num1--
            if (num1 < 0) {
                //If score is less than zero set it to 0
                score1.setText("0")
                num1 = 0
            } else {
                score1.setText("$num1")
            }
        }

        //Increase score if second score(+) is clicked
        val btn2_increase = findViewById<Button>(R.id.btn2_increase)
        btn2_increase.setOnClickListener {
            num2++
            score2.setText("$num2")
        }

        //Decrease score if second score(-) is clicked
        val btn2_decrease = findViewById<Button>(R.id.btn2_decrease)
        btn2_decrease.setOnClickListener {
            num2--
            if (num2 < 0) {
                //If score is less than zero set it to 0
                score2.setText("0")
                num2 = 0
            } else {
                score2.setText("$num2")
            }

        }

        //update score with the help of spinner
        spinner1.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val position_val = score[position]
                val val_to_int = position_val.toInt()
                val final1 = val_to_int + num1
                num1 = final1
                score1.setText("$num1")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner2.onItemSelectedListener = object :

            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val position_val = score[position]
                val val_to_int = position_val.toInt()
                val final2 = val_to_int + num2
                num2 = final2
                score2.setText("$num2")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

    // Inflate the options menu layout to display in the app's action bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu) // this inflates the menu layout
        return true


    }

    // Handle options menu item selections
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_about -> {
                // Display toast message with developer information

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



