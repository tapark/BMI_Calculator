package com.example.part2_chap01_bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlin.math.pow
import kotlin.math.round


class ResultActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        Log.d("ResultActivity", "$height / $weight")

        val bmiTemp = weight / (height / 100.0).pow(2.0)

        val bmi = round(bmiTemp * 1000) / 1000

        val resultText = when {
            bmi >= 35.0 -> "고도비만"
            bmi >= 30.0 -> "중경도비만"
            bmi >= 25.0 -> "경도비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상체중"
            else -> "저체중"
        }

        val maxWeight = 22.99 * (height / 100.0).pow(2.0)
        val minWeight = 18.5 *  (height / 100.0).pow(2.0)
        val averageWeight = round((maxWeight + minWeight) / 2 * 100) / 100

        val needWeight = findViewById<TextView>(R.id.needWeight)
        val needText = findViewById<TextView>(R.id.needText)

        var calWeight = weight - averageWeight

        if (calWeight >= 0)
            needText.text = "감량"
        else {
            needText.text = "증량"
            calWeight *= -1
        }
        needWeight.text = (round(calWeight * 100) / 100).toString()

        val idleWeight = findViewById<TextView>(R.id.idleWeight)
        val idleHeight = findViewById<TextView>(R.id.idleHeight)

        idleWeight.text = averageWeight.toString()
        idleHeight.text = height.toString()

        val yourWeight = findViewById<TextView>(R.id.yourWeight)

        yourWeight.text = weight.toString()

        val bmiValue = findViewById<TextView>(R.id.bmiValue)
        val bmiResult = findViewById<TextView>(R.id.bmiResult)

        bmiValue.text = bmi.toString()
        bmiResult.text = resultText

        val returnMain = findViewById<Button>(R.id.returnMain)

        returnMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }
    }
}