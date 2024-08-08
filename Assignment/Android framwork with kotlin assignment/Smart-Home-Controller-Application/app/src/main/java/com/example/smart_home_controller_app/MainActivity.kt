package com.example.smart_home_controller_app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.smart_home_controller_app.databinding.ActivityMainBinding
import com.example.smart_home_controller_app.DeviceCommand
import com.example.smart_home_controller_app.DeviceStatus
import com.example.smart_home_controller_app.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnToggleLight.setOnClickListener {
            toggleLight()
        }

        binding.switchThermostat.setOnCheckedChangeListener { _, isChecked ->
            toggleThermostat(isChecked)
        }

        binding.btnSettings.setOnClickListener {
            openSettings()
        }

        fetchDeviceStatus()
        schedulePeriodicSync()
    }

    private fun toggleLight() {
        val command = DeviceCommand("toggle_light")
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.apiService.controlDevice(command)
                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        // Update UI based on success
                        Toast.makeText(this@MainActivity, "Light toggled", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        // Handle error
                        Toast.makeText(this@MainActivity, "Failed to toggle light", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    // Handle network error
                    Toast.makeText(this@MainActivity, "Network error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun toggleThermostat(isChecked: Boolean) {
        val command = DeviceCommand(if (isChecked) "turn_on_thermostat" else "turn_off_thermostat")
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.apiService.controlDevice(command)
                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        // Update UI based on success
                        Toast.makeText(this@MainActivity, "Thermostat updated", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        // Handle error
                        Toast.makeText(this@MainActivity, "Failed to update thermostat", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    // Handle network error
                    Toast.makeText(this@MainActivity, "Network error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun fetchDeviceStatus() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.apiService.getDeviceStatus()
                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        val status = response.body()
                        binding.switchThermostat.isChecked = status?.thermostatStatus ?: false
                        binding.tvDeviceStatus.text = "Light: ${if (status?.lightStatus == true) "On" else "Off"}\nThermostat: ${if (status?.thermostatStatus == true) "On" else "Off"}"
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        // Handle error
                        Toast.makeText(this@MainActivity, "Failed to fetch device status", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    // Handle network error
                    Toast.makeText(this@MainActivity, "Network error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun openSettings() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

    private fun schedulePeriodicSync() {
        val syncWorkRequest = PeriodicWorkRequestBuilder<SyncWorker>(15, TimeUnit.MINUTES)
            .build()

        WorkManager.getInstance(this).enqueue(syncWorkRequest)
    }
}