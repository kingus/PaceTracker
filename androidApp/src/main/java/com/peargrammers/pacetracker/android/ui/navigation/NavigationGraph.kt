package com.peargrammers.pacetracker.android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.peargrammers.pacetracker.android.ui.screens.TrainingFormScreen
import com.peargrammers.pacetracker.android.ui.screens.TrainingScreen

@Composable
fun NavigationGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.TrainingFormScreen.route) {
        composable(route = Screen.TrainingFormScreen.route) {
            TrainingFormScreen(navController = navController)
        }
        composable(route = Screen.TrainingScreen.route) {
            TrainingScreen(navController = navController)
        }
    }
}