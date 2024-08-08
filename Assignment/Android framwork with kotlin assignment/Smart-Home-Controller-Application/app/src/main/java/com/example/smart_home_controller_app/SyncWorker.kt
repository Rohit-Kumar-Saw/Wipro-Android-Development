package com.example.smart_home_controller_app

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.smart_home_controller_app.RetrofitClient
import java.lang.Exception

class SyncWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        return try {
            // Perform sync task
            val response = RetrofitClient.apiService.getDeviceStatus()
            if (response.isSuccessful) {
                val status = response.body()
                // Apply automation rules based on device status
                if (status?.lightStatus == false) {
                    // Example: Automatically turn on the light
                    RetrofitClient.apiService.controlDevice(DeviceCommand("turn_on_light"))
                }
                Result.success()
            } else {
                Result.retry()
            }
        } catch (e: Exception) {
            Result.retry()
        }
    }
}