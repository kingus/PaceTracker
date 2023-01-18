package com.peargrammers.pacetracker.android.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.peargrammers.pacetracker.android.ui.screens.TrainingFormScreen
import com.peargrammers.pacetracker.android.ui.screens.TrainingRunPeriodFormScreen
import com.peargrammers.pacetracker.android.ui.screens.TrainingScreen

fun NavGraphBuilder.trainingNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.TRAINING,
        startDestination = TrainingScreen.TrainingForm.route
    ) {
        composable(route = TrainingScreen.Training.route) {
           TrainingScreen(navController = navController)
        }
        composable(route = TrainingScreen.TrainingForm.route) {
            TrainingFormScreen(
                onClick = {
                    navController.navigate(TrainingScreen.TrainingRunPeriodForm.route)
                },
                onConfirmClick = {
//                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                })
        }
        composable(route = TrainingScreen.TrainingRunPeriodForm.route) {
            TrainingRunPeriodFormScreen(onClick = {
                navController.navigate(TrainingScreen.TrainingForm.route)
            })
        }
    }
}

sealed class TrainingScreen(val route: String) {
    object Training : TrainingScreen(route = "TRAINING")
    object TrainingForm : TrainingScreen(route = "TRAINING_FORM")
    object TrainingRunPeriodForm : TrainingScreen(route = "TRAINING_RUN_PERIOD_FORM")
}