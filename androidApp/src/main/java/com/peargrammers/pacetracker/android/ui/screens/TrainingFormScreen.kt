package com.peargrammers.pacetracker.android.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.peargrammers.pacetracker.android.ui.components.CustomButton
import com.peargrammers.pacetracker.android.ui.components.input.CustomTextField
import com.peargrammers.pacetracker.android.navigation.Screen

@Composable
fun TrainingFormScreen(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        CustomTextField("Distance", "km")
        CustomTextField("Target pace", "km/h")
        CustomButton(
            onClick = { navController.navigate(Screen.TrainingScreen.route) },
            label = "Confirm"
        )
    }
}
