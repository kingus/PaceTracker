package com.peargrammers.pacetracker.android.navigation.bottom

sealed class Screen(val route: String) {
    object TrainingFormScreen : Screen("training_form_screen")
    object SettingsScreen : Screen("settings_screen")
    object ProfileScreen : Screen("profile_screen")
}