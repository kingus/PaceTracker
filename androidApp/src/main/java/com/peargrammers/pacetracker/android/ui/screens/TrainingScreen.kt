package com.peargrammers.pacetracker.android.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.peargrammers.pacetracker.android.ui.components.training.*

@Composable
fun TrainingScreen(navController: NavController) {
    Column {
        TimeDistanceCard()
        PaceCard()
        PlayButton(modifier = Modifier.align(CenterHorizontally))
    }
}