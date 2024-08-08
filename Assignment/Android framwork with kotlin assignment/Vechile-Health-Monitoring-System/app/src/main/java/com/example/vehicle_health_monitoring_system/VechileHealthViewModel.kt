package com.example.vehicle_health_monitoring_system

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vehicle_health_monitoring_system.VehicleHealthResponse
import com.example.vehicle_health_monitoring_system.RetrofitInstance
import com.example.vehicle_health_monitoring_system.VehicleService
import kotlinx.coroutines.launch
import retrofit2.HttpException

class VehicleHealthViewModel : ViewModel() {

    private val _engineHealth = MutableLiveData<String>().apply { value = "Engine Health: Checking..." }
    val engineHealth: LiveData<String> get() = _engineHealth

    private val _oilLevel = MutableLiveData<String>().apply { value = "Oil Level: Checking..." }
    val oilLevel: LiveData<String> get() = _oilLevel

    private val _tirePressure = MutableLiveData<String>().apply { value = "Tire Pressure: Checking..." }
    val tirePressure: LiveData<String> get() = _tirePressure

    private val vehicleService = RetrofitInstance.retrofit.create(VehicleService::class.java)

    init {
        fetchVehicleHealth()
    }

    fun fetchVehicleHealth() {
        viewModelScope.launch {
            try {
                val response = vehicleService.getVehicleHealth().execute()
                if (response.isSuccessful) {
                    val data = response.body()
                    _engineHealth.value = data?.engineHealth ?: "Engine Health: Unknown"
                    _oilLevel.value = data?.oilLevel ?: "Oil Level: Unknown"
                    _tirePressure.value = data?.tirePressure ?: "Tire Pressure: Unknown"
                } else {
                    _engineHealth.value = "Engine Health: Error"
                    _oilLevel.value = "Oil Level: Error"
                    _tirePressure.value = "Tire Pressure: Error"
                }
            } catch (e: HttpException) {
                _engineHealth.value = "Engine Health: Error"
                _oilLevel.value = "Oil Level: Error"
                _tirePressure.value = "Tire Pressure: Error"
            } catch (e: Exception) {
                _engineHealth.value = "Engine Health: Error"
                _oilLevel.value = "Oil Level: Error"
                _tirePressure.value = "Tire Pressure: Error"
            }
        }
    }
}
