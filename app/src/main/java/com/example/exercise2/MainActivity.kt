package com.example.exercise2

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val cal = findViewById<Button>(R.id.buttonCalculate)
        val reset = findViewById<Button>(R.id.buttonReset)
        val toast = Toast.makeText(applicationContext, "Input Required", Toast.LENGTH_SHORT)
        val img: ImageView = findViewById(R.id.imageViewProfile)
        img.setImageResource(R.drawable.empty)

        cal.setOnClickListener{
            if(editTextHeight.text.isEmpty() || editTextWeight.text.isEmpty()){
                toast.show()
            }else{
                val weight = editTextWeight.text.toString().toDouble()
                val height = editTextHeight.text.toString().toDouble()

                val bmi = weight / pow((height/100), 2.0)


                if(bmi < 18.5){
                    textViewBMI.text = "BMI : " + String.format("%.2f",bmi) + " Underweight"
                    img.setImageResource(R.drawable.under)
                }else if(bmi in 18.5..24.9){
                    textViewBMI.text = "BMI : " + String.format("%.2f",bmi) + " Normal"
                    img.setImageResource(R.drawable.normal)
                }else if(bmi >= 25){
                    textViewBMI.text = "BMI : " + String.format("%.2f",bmi) + " Overweight"
                    img.setImageResource(R.drawable.over)
                }
            }
        }

        reset.setOnClickListener{
            editTextHeight.setText("")
            editTextWeight.setText("")
            textViewBMI.text = "BMI :"
            img.setImageResource(R.drawable.empty)


        }


    }
}
