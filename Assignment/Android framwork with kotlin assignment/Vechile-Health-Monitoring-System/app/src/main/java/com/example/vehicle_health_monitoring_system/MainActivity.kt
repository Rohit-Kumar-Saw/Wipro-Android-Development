package com.example.vehicle_health_monitoring_system

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.work.*
import com.example.vechile_health_monitoring_system.R
import com.example.vechile_health_monitoring_system.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: VehicleHealthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = VehicleHealthViewModel()

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val diagnosticsWorkRequest = OneTimeWorkRequestBuilder<VehicleHealthWorker>()
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(this).enqueue(diagnosticsWorkRequest)

        binding.settingsButton.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }
}
