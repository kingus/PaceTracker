package com.peargrammers.pacetracker.android.navigation.bottom

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.peargrammers.pacetracker.android.navigation.Screen
import com.peargrammers.pacetracker.android.ui.screens.MainScreen
import com.peargrammers.pacetracker.android.ui.screens.TrainingFormScreen
import com.peargrammers.pacetracker.android.ui.screens.TrainingScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomScreen.TrainingScreen.route
    ) {
        composable(route = Screen.TrainingFormScreen.route) {
            TrainingFormScreen(navController = navController)
        }
        composable(route = Screen.TrainingScreen.route) {
            TrainingScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
    }
}