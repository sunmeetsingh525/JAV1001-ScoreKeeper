package com.example.layouts_and_views
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

//first
class MainActivity : AppCompatActivity() {
    var num1:Int = 0
    var num2:Int = 0

    @SuppressLint("ResourceType", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Create array of basketball points
        val score = arrayOf("0","1", "2", "3")
        val spinner1 = findViewById<Spinner>(R.id.result1)
        val spinner2 = findViewById<Spinner>(R.id.result2)
        var arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, score
        )
        spinner1.adapter = arrayAdapter
        spinner2.adapter = arrayAdapter

        var score1 = findViewById<TextView>(R.id.score1)
        var score2 = findViewById<TextView>(R.id.score2)


        //Increase score if first score(+) is clicked
        var btn1_increase = findViewById<Button>(R.id.btn1_increase)
        btn1_increase.setOnClickListener {
            num1++
           score1.setText("$num1")
        }

        //Decrease score if first score(-) is clicked
        var btn1_decrease = findViewById<Button>(R.id.btn1_decrease)
        btn1_decrease.setOnClickListener {
            num1--
            if(num1<0){
                //If score is less than zero set it to 0
                score1.setText("0")
                num1 = 0
            }else{
                score1.setText("$num1")
            }
        }

        //Increase score if second score(+) is clicked
        var btn2_increase = findViewById<Button>(R.id.btn2_increase)
        btn2_increase.setOnClickListener {
            num2++
            score2.setText("$num2")
        }

        //Decrease score if second score(-) is clicked
        var btn2_decrease = findViewById<Button>(R.id.btn2_decrease)
        btn2_decrease.setOnClickListener {
            num2--
            if(num2<0){
                //If score is less than zero set it to 0
                score2.setText("0")
                num2 = 0
            }else
            {
                score2.setText("$num2")
            }

        }


     //update score with the help of spinner
        //got some issued with it

        spinner1.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    var position_val = score[position]
                    var val_to_int = position_val.toInt()
                    var final1 = val_to_int+num1
                    num1 = final1
                    score1.setText("$num1")
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
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
                var position_val = score[position]
                var val_to_int = position_val.toInt()
                var final2 = val_to_int+num2
                num2 = final2
                score2.setText("$num2")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }



            }
       }


///changes
//TODO : COMPLETE

