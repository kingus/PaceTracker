package com.peargrammers.pacetracker.android.navigation.bottom

import com.peargrammers.pacetracker.android.R

sealed class BottomBarScreen(val route: String, val icon: Int, val title: String) {
    object Profile :
        BottomBarScreen(Screen.ProfileScreen.route, R.drawable.ic_outline_home, "Profile")

    object Settings :
        BottomBarScreen(Screen.SettingsScreen.route, R.drawable.ic_timer, "Settings")
}