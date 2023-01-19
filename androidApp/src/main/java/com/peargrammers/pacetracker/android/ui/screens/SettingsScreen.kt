package com.peargrammers.pacetracker.android.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.peargrammers.pacetracker.android.ui.components.custom.buttons.CustomButton

@Composable
fun SettingsScreen(onClick: () -> Unit) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()
    ) {
        CustomButton(onClick = onClick, "Go to training", modifier = Modifier)
    }

}