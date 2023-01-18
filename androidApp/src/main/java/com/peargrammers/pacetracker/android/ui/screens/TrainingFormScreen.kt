package com.peargrammers.pacetracker.android.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.peargrammers.pacetracker.android.navigation.Screen
import com.peargrammers.pacetracker.android.ui.components.custom.buttons.CustomButton
import com.peargrammers.pacetracker.android.ui.components.form.TrainingGroupCard

@Composable
fun TrainingFormScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier.weight(1f)) {
            TrainingGroupCard() {
                navController.navigate(Screen.RunPeriodForm.route)
            }
        }
        CustomButton(
            onClick = { navController.navigate(Screen.TrainingScreen.route) },
            label = "Confirm"
        )
    }
}
