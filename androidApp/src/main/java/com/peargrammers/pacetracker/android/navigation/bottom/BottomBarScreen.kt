package com.peargrammers.pacetracker.android.navigation.bottom

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val icon: ImageVector,
    val iconFocused: ImageVector,
    val title: String
) {
    object Home :
        BottomBarScreen("main_screen", Icons.Outlined.Home, Icons.Default.Home, "Home")

    object Settings :
        BottomBarScreen(
            "settings_screen",
            Icons.Outlined.Settings,
            Icons.Default.Settings,
            "Settings"
        )

    object Workouts :
        BottomBarScreen(
            "history_activities_screen",
            Icons.Outlined.Timer,
            Icons.Default.Timer,
            "Activities"
        )
}