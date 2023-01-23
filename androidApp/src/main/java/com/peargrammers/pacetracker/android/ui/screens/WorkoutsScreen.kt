package com.peargrammers.pacetracker.android.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.peargrammers.pacetracker.android.ui.components.profile.RecentActivityItem
import com.peargrammers.pacetracker.android.ui.components.profile.RecentActivityItemWithDate

@Composable
fun WorkoutsScreen(navController: NavController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()
    ) {

        RecentActivityItemWithDate()
        RecentActivityItemWithDate()
        RecentActivityItem()

    }
}