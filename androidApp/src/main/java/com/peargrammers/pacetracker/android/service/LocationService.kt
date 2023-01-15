package com.peargrammers.pacetracker.android.service

import android.app.Service
import android.content.Intent
import android.location.Location
import android.os.Binder
import androidx.compose.runtime.mutableStateOf
import com.peargrammers.pacetracker.android.data.repository.TrainingRepository
import com.peargrammers.pacetracker.android.location.DefaultLocationClient
import com.peargrammers.pacetracker.android.utils.Constants.ACTION_SERVICE_START
import com.peargrammers.pacetracker.android.utils.Constants.ACTION_SERVICE_STOP
import com.peargrammers.pacetracker.android.utils.LocationConverter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class LocationService : Service() {

    @Inject
    lateinit var trainingRepository: TrainingRepository

    @Inject
    lateinit var locationClient: DefaultLocationClient

    private lateinit var serviceScope: CoroutineScope
    private val binder = LocationServiceBinder()

    private var currentState = mutableStateOf(State.Stopped)
    private var pace = mutableStateOf("0")
    private var distance = mutableStateOf(0f)

    override fun onCreate() {
        super.onCreate()
        serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    }

    override fun onBind(p0: Intent?) = binder

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        intent?.action.let {
            println("onStartCommand $it")

            when (it) {
                ACTION_SERVICE_START -> startService()
                ACTION_SERVICE_STOP -> stopService()
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun startService() {
        println("startService() ${currentState.value}")

        serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
        currentState.value = State.Started

        trainingRepository.serviceState.postValue(currentState.value)

        val startPoint = Location("startLocation")
        startPoint.latitude = 17.372102
        startPoint.longitude = 78.484196

        var firstLocation = true
        val interval = 15000L

        locationClient
            .getLocationUpdate(interval)
            .catch { e -> e.printStackTrace() }
            .onEach { location ->

                if (firstLocation) {
                    startPoint.latitude = location.latitude
                    startPoint.longitude = location.longitude
                    firstLocation = false
                }

                val endPoint = Location("endLocation")
                endPoint.latitude = location.latitude
                endPoint.longitude = location.longitude

                val currentDistance = LocationConverter.calculateDistance(startPoint, endPoint)

                distance.value += currentDistance

                startPoint.latitude = endPoint.latitude
                startPoint.longitude = endPoint.longitude

                val speed_m_s =
                    LocationConverter.calculateSpeedMetersPerSecond(currentDistance, interval)
                val speed_km_h =
                    LocationConverter.convertSpeedToKilometersPerHour(speed_m_s)

                pace.value = speed_km_h.toString()
                trainingRepository.pace.postValue(pace.value)
                trainingRepository.distance.postValue(distance.value)

                println("CURRENT DISTANCE ${distance.value}")
                println("NUM $speed_km_h")
            }
            .launchIn(serviceScope)
    }

    private fun stopService() {
        currentState.value = State.Stopped
        trainingRepository.serviceState.postValue(currentState.value)
        println("stopService() ${currentState.value}")
        stopSelf()
        serviceScope.cancel()
    }


    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
    }

    inner class LocationServiceBinder : Binder() {
        fun getService(): LocationService = this@LocationService
    }

    enum class State {
        Started, Stopped;
    }
}