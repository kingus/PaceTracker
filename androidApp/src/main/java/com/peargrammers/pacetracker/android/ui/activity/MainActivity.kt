package com.peargrammers.pacetracker.android.ui.activity

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.peargrammers.pacetracker.android.navigation.NavigationGraph
import com.peargrammers.pacetracker.android.navigation.graphs.RootNavigationGraph
import com.peargrammers.pacetracker.android.service.LocationService
import com.peargrammers.pacetracker.android.ui.theme.PaceTrackerTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var locationService: LocationService

    private var isBound by mutableStateOf(false)
    private val connection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            val binder = service as LocationService.LocationServiceBinder

            println("CONNECTION onServiceConnected")
            locationService = binder.getService()
            isBound = true
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            isBound = false
            println("CONNECTION onServiceDisconnected")

        }
    }

    override fun onStart() {
        println("MainActivity onStart()")
        Intent(this, LocationService::class.java).also { intent ->
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
        super.onStart()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaceTrackerTheme {
                val navController = rememberNavController()
                Column() {
                    RootNavigationGraph(navController = navController)
                }
            }
        }
    }
}