package com.example.part2_chap01_bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText: EditText = findViewById<EditText>(R.id.heightEditText)
        val weightEditText: EditText = findViewById<EditText>(R.id.weightEditTExt)

        val resultButton: Button = findViewById<Button>(R.id.resultButton)

        resultButton.setOnClickListener {
            Log.d("MainActivity", "결과버튼감지")

            if (heightEditText.text.isEmpty() || weightEditText.text.isEmpty()) {
                Toast.makeText(this, "빈값", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val height: Int = heightEditText.text.toString().toInt()
            val weight: Int = weightEditText.text.toString().toInt()

            val intent = Intent(this, ResultActivity::class.java)

            intent.putExtra("height", height)
            intent.putExtra("weight", weight)

            startActivity(intent)
        }
    }
}