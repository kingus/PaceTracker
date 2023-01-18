package com.peargrammers.pacetracker.android.ui.components.form

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.peargrammers.pacetracker.android.ui.components.custom.input.CustomTextField
import com.peargrammers.pacetracker.android.ui.theme.spacing

@Composable
fun TrainingPeriodCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(MaterialTheme.spacing.medium),
        shape = RoundedCornerShape(MaterialTheme.spacing.extraLarge),
        backgroundColor = Color.White,
        elevation = 3.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp, 30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTextField("Distance", "km")
            CustomTextField("Target pace", "km/h")
            CustomTextField("Pace status frequency", "")

        }
    }
}