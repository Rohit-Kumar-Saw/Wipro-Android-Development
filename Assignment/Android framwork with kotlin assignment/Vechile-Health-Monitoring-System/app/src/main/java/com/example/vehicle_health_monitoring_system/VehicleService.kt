package com.example.vehicle_health_monitoring_system

import com.example.vehicle_health_monitoring_system.VehicleHealthResponse
import com.example.vehicle_health_monitoring_system.IssueReport
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface VehicleService {
    @GET("vehicle/health")
    fun getVehicleHealth(): Call<VehicleHealthResponse>

    @POST("vehicle/report")
    fun reportIssue(@Body issueReport: IssueReport): Call<Void>
}