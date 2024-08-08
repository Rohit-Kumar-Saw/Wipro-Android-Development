package com.example.vehicle_health_monitoring_system

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.vehicle_health_monitoring_system.VehicleService
import retrofit2.HttpException

class VehicleHealthWorker(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {

    override fun doWork(): Result {
        val vehicleService = RetrofitInstance.retrofit.create(VehicleService::class.java)

        return try {
            val response = vehicleService.getVehicleHealth().execute()
            if (response.isSuccessful) {
                // Sync data with server or local storage
                Result.success()
            } else {
                Result.retry()
            }
        } catch (e: HttpException) {
            Result.retry()
        } catch (e: Exception) {
            Result.retry()
        }
    }
}