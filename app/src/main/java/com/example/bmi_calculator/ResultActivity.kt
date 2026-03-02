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
        
        val mainView = findViewById<android.view.View>(R.id.main)
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        val tvDetails = findViewById<TextView>(R.id.tvDetails)
        val tvBMI = findViewById<TextView>(R.id.tvBMI)
        val tvCategory = findViewById<TextView>(R.id.tvCategory)
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

            val (category, color) = when {
                bmi < 18.5 -> "Underweight" to Color.BLUE
                bmi < 25 -> "Normal Weight" to Color.parseColor("#4CAF50") // Green
                bmi < 30 -> "Overweight" to Color.parseColor("#FF9800") // Orange
                else -> "Obese" to Color.RED
            }

            tvDetails.text = getString(R.string.details_format, name, age)
            tvBMI.text = "%.1f".format(bmi)
            tvCategory.text = category
            tvCategory.setTextColor(color)
        } else {
            tvBMI.text = getString(R.string.invalid_data)
        }
    }
}
