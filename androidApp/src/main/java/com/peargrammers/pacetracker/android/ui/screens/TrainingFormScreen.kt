package com.peargrammers.pacetracker.android.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.peargrammers.pacetracker.android.ui.components.custom.buttons.CustomButton
import com.peargrammers.pacetracker.android.ui.components.form.TrainingGroupCard

@Composable
fun TrainingFormScreen(onConfirmClick: () -> Unit, onClickRun: () -> Unit, onClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.weight(1f)) {
            TrainingGroupCard(onClick)
        }
        CustomButton(
            onClick = { onClickRun() },
            label = "Go to run"
        )
    }
}