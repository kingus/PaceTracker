package com.peargrammers.pacetracker.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.peargrammers.pacetracker.android.ui.screens.MainScreen
import com.peargrammers.pacetracker.android.ui.screens.RunPeriodForm
import com.peargrammers.pacetracker.android.ui.screens.TrainingFormScreen
import com.peargrammers.pacetracker.android.ui.screens.TrainingScreen

@Composable
fun NavigationGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.TrainingFormScreen.route) {
            TrainingFormScreen(navController = navController)
        }
        composable(route = Screen.TrainingScreen.route) {
            TrainingScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.RunPeriodForm.route) {
            RunPeriodForm(navController = navController)
        }
    }
}