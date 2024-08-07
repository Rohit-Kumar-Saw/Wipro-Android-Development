package com.example.kdemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val btn = findViewById<Button>(R.id.button);

        btn?.setOnClickListener(){
            Toast.makeText(this@MainActivity, "Button is clicked", Toast.LENGTH_SHORT).show();
        }

           }
}
