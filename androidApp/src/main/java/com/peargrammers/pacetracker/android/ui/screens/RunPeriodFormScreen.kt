package com.peargrammers.pacetracker.android.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.peargrammers.pacetracker.android.navigation.Screen
import com.peargrammers.pacetracker.android.ui.components.custom.buttons.CustomButton
import com.peargrammers.pacetracker.android.ui.components.custom.input.CustomTextField

@Composable
fun RunPeriodForm(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(modifier = Modifier.weight(1f)
        ) {
            CustomTextField("Distance", "km")
            CustomTextField("Target pace", "km/h")
            CustomTextField("Pace status frequency", "")
        }
        CustomButton(
            onClick = { navController.navigate(Screen.TrainingFormScreen.route) },
            label = "Add to group"
        )
    }

}