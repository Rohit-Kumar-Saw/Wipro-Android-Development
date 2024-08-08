package com.example.smart_home_controller_app

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

data class DeviceCommand(val command: String)
data class DeviceStatus(val lightStatus: Boolean, val thermostatStatus: Boolean)

interface ApiService {
    @POST("device/control")
    fun controlDevice(@Body command: DeviceCommand): Response<Unit>

    @GET("devices/status")
    fun getDeviceStatus(): Response<DeviceStatus>
}