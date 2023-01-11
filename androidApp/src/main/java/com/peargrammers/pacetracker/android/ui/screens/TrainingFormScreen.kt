package com.peargrammers.pacetracker.android.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.peargrammers.pacetracker.android.ui.components.input.CustomTextField

@Composable
fun TrainingFormScreen() {
    Column {
        CustomTextField("Distance", "km")
        CustomTextField("Target pace", "km/h")

    }
}