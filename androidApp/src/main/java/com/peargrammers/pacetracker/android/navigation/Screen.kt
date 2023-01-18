package com.peargrammers.pacetracker.android.navigation

sealed class Screen(val route: String) {
    object TrainingFormScreen : Screen("training_form_screen")
    object TrainingScreen : Screen("training_screen")
    object MainScreen : Screen("main_screen")
    object RunPeriodForm : Screen("run_period_form_screen")
}