package com.peargrammers.pacetracker.android.navigation.bottom

import com.peargrammers.pacetracker.android.R
import com.peargrammers.pacetracker.android.navigation.Screen

sealed class BottomScreen(val route: String, val icon: Int, val title: String) {
    object TrainingFormScreen :
        BottomScreen(Screen.TrainingFormScreen.route, R.drawable.ic_outline_home, "Form")

    object TrainingScreen :
        BottomScreen(Screen.TrainingScreen.route, R.drawable.ic_timer, "Training")

    object MainScreen : BottomScreen(Screen.MainScreen.route, R.drawable.ic_speed, "Main")
}