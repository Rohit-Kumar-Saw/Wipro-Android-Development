package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Check if user is already authenticated
        val isAuthenticated = checkAuthentication()

        if (isAuthenticated) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        finish() // Close MainActivity
    }

    private fun checkAuthentication(): Boolean {
        // Replace with actual authentication check
        // For demonstration, we'll assume the user is not authenticated
        return false
    }
}
