package com.peargrammers.pacetracker.android.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.peargrammers.pacetracker.android.navigation.bottom.BottomBarScreen
import com.peargrammers.pacetracker.android.ui.screens.MainScreen
import com.peargrammers.pacetracker.android.ui.screens.SettingsScreen
import com.peargrammers.pacetracker.android.ui.screens.WorkoutsScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            MainScreen(navController = navController)
        }
        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen(onClick = {
                navController.navigate(Graph.TRAINING)
            })
        }
        composable(route = BottomBarScreen.Workouts.route) {
            WorkoutsScreen(navController = navController)
        }
        trainingNavGraph(navController = navController)

    }
}