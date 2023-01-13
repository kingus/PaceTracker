package com.peargrammers.pacetracker.android.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.peargrammers.pacetracker.android.navigation.NavigationGraph
import com.peargrammers.pacetracker.android.ui.theme.PaceTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaceTrackerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    Column {
                        val navController = rememberNavController()
                        NavigationGraph(navController = navController)
                    }
                }
            }
        }
    }
}
