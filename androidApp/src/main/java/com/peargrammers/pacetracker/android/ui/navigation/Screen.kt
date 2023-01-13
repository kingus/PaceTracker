package com.peargrammers.pacetracker.android.ui.navigation

sealed class Screen(val route: String) {
    object TrainingFormScreen : Screen("training_form_screen")
    object TrainingScreen : Screen("training_screen")
}