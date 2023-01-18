package com.peargrammers.pacetracker.android.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.peargrammers.pacetracker.android.navigation.bottom.BottomBarScreen
import com.peargrammers.pacetracker.android.ui.screens.ProfileScreen
import com.peargrammers.pacetracker.android.ui.screens.SettingsScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Profile.route
    ) {
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen(navController = navController)
        }
    }
}