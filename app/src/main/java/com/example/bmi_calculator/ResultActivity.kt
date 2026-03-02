package com.example.bmi_calculator

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvDetails = findViewById<TextView>(R.id.tvDetails)
        val tvBMI = findViewById<TextView>(R.id.tvBMI)
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            finish()
        }

        val name = intent.getStringExtra("name") ?: ""
        val age = intent.getStringExtra("age") ?: ""
        val heightStr = intent.getStringExtra("height")
        val weightStr = intent.getStringExtra("weight")

        val heightCm = heightStr?.toDoubleOrNull() ?: 0.0
        val weight = weightStr?.toDoubleOrNull() ?: 0.0

        if (heightCm > 0) {
            val heightM = heightCm / 100
            val bmi = weight / (heightM * heightM)

            val category: String
            val color: Int

            when {
                bmi < 18.5 -> {
                    category = "Underweight"
                    color = Color.BLUE
                }
                bmi < 25 -> {
                    category = "Normal"
                    color = Color.parseColor("#4CAF50") // Green
                }
                bmi < 30 -> {
                    category = "Overweight"
                    color = Color.parseColor("#FF9800") // Orange
                }
                else -> {
                    category = "Obese"
                    color = Color.RED
                }
            }

            tvDetails.text = getString(R.string.details_format, name, age)
            tvBMI.text = getString(R.string.bmi_format, bmi, category)
            tvBMI.setTextColor(color)
        } else {
            tvBMI.text = getString(R.string.invalid_data)
        }
    }
}