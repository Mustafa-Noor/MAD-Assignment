package com.example.bmi_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var etHeight: EditText
    private lateinit var etWeight: EditText
    private lateinit var btnShow: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        val mainView = findViewById<android.view.View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etName = findViewById(R.id.etName)
        etAge = findViewById(R.id.etAge)
        etHeight = findViewById(R.id.etHeight)
        etWeight = findViewById(R.id.etWeight)
        btnShow = findViewById(R.id.btnShow)

        btnShow.setOnClickListener {
            if (validateInputs()) {
                val name = etName.text.toString().trim()
                val age = etAge.text.toString().trim()
                val height = etHeight.text.toString().trim()
                val weight = etWeight.text.toString().trim()

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("age", age)
                intent.putExtra("height", height)
                intent.putExtra("weight", weight)
                startActivity(intent)
            }
        }
    }

    private fun validateInputs(): Boolean {
        var isValid = true

        val name = etName.text.toString().trim()
        if (name.isEmpty()) {
            etName.error = getString(R.string.error_name_required)
            isValid = false
        } else if (name.length < 2) {
            etName.error = getString(R.string.error_name_short)
            isValid = false
        }

        val ageStr = etAge.text.toString().trim()
        val age = ageStr.toIntOrNull()
        if (ageStr.isEmpty()) {
            etAge.error = getString(R.string.error_age_required)
            isValid = false
        } else if (age == null || age <= 0 || age > 120) {
            etAge.error = getString(R.string.error_age_range)
            isValid = false
        }

        val heightStr = etHeight.text.toString().trim()
        val height = heightStr.toDoubleOrNull()
        if (heightStr.isEmpty()) {
            etHeight.error = getString(R.string.error_height_required)
            isValid = false
        } else if (height == null || height < 50 || height > 250) {
            etHeight.error = getString(R.string.error_height_range)
            isValid = false
        }

        val weightStr = etWeight.text.toString().trim()
        val weight = weightStr.toDoubleOrNull()
        if (weightStr.isEmpty()) {
            etWeight.error = getString(R.string.error_weight_required)
            isValid = false
        } else if (weight == null || weight < 2 || weight > 500) {
            etWeight.error = getString(R.string.error_weight_range)
            isValid = false
        }

        return isValid
    }
}
