package com.peargrammers.pacetracker.android.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.peargrammers.pacetracker.android.ui.screens.HomeScreen

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.HOME
    ) {
//        trainingNavGraph(navController = navController)
        composable(route = Graph.HOME) {
            HomeScreen()
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val TRAINING = "training_graph"
    const val HOME = "home_graph"
}