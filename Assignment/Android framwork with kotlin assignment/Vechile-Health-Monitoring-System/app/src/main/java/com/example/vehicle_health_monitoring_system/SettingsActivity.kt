package com.example.vehicle_health_monitoring_system

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.example.vechile_health_monitoring_system.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class SettingsActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var tirePressureThresholdEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        tirePressureThresholdEditText = findViewById(R.id.tirePressureThreshold)
        val saveSettingsButton: Button = findViewById(R.id.saveSettingsButton)
        val reportIssueButton: Button = findViewById(R.id.reportIssueButton)

        saveSettingsButton.setOnClickListener {
            val threshold = tirePressureThresholdEditText.text.toString().toDoubleOrNull()
            if (threshold != null) {
                sharedPreferences.edit().putFloat("tire_pressure_threshold", threshold.toFloat()).apply()
                Toast.makeText(this, "Settings saved", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
            }
        }

        reportIssueButton.setOnClickListener {
            val issueReport = IssueReport("Sample issue description") // This could be a dialog input
            val vehicleService = RetrofitInstance.retrofit.create(VehicleService::class.java)
            vehicleService.reportIssue(issueReport).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        Toast.makeText(this@SettingsActivity, "Issue reported", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@SettingsActivity, "Failed to report issue", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(this@SettingsActivity, "Network error", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}