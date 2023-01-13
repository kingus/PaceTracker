package com.peargrammers.pacetracker.android.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.peargrammers.pacetracker.android.ui.components.CustomButton
import com.peargrammers.pacetracker.android.ui.components.input.CustomTextField

@Composable
fun TrainingFormScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        CustomTextField("Distance", "km")
        CustomTextField("Target pace", "km/h")
        CustomButton(onClick = {}, label = "Confirm")
    }
}
