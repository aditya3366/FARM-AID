package com.example.projectk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnWeather: Button
    private lateinit var btnDiagnose: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnWeather = findViewById(R.id.weather_btn)
        btnDiagnose = findViewById(R.id.diagnose_btn)

        btnWeather.setOnClickListener{
            val intent = Intent(this,Weather::class.java)
            startActivity(intent)
        }
        btnDiagnose.setOnClickListener{
            val intent = Intent(this,Diagnose::class.java)
            startActivity(intent)
        }

    }
}