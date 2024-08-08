package com.example.smart_home_controller_app

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.example.smart_home_controller_app.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        binding.btnSave.setOnClickListener {
            savePreferences()
        }
    }

    private fun savePreferences() {
        with(sharedPreferences.edit()) {
            putString("user_setting", binding.editTextUserSetting.text.toString())
            apply()
        }
    }
}