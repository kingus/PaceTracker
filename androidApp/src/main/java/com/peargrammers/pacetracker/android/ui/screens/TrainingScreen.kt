package com.peargrammers.pacetracker.android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.observe
import androidx.navigation.NavController
import com.peargrammers.pacetracker.android.R
import com.peargrammers.pacetracker.android.TrainingViewModel
import com.peargrammers.pacetracker.android.service.LocationService
import com.peargrammers.pacetracker.android.service.ServiceHandler
import com.peargrammers.pacetracker.android.ui.components.custom.buttons.ChangeableCircleButton
import com.peargrammers.pacetracker.android.ui.components.training.*
import com.peargrammers.pacetracker.android.ui.theme.LightGrey
import com.peargrammers.pacetracker.android.utils.Constants.ACTION_SERVICE_START
import com.peargrammers.pacetracker.android.utils.Constants.ACTION_SERVICE_STOP

@Composable
fun TrainingScreen(
    navController: NavController,
    viewModel: TrainingViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    val currentState = remember { mutableStateOf(LocationService.State.Stopped) }

    viewModel.serviceState.observe(LocalLifecycleOwner.current) { state ->
        currentState.value = state
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGrey)
    ) {
        TimeDistanceCard(viewModel)
        PaceCard(viewModel)
        ChangeableCircleButton(
            modifier = Modifier.align(CenterHorizontally), onClick = {
                ServiceHandler.triggerForegroundService(
                    context = context,
                    action = if (currentState.value == LocationService.State.Started) {
                        ACTION_SERVICE_STOP
                    } else if (currentState.value == LocationService.State.Stopped) {
                        ACTION_SERVICE_START
                    } else {
                        ACTION_SERVICE_STOP
                    }
                )

                println("STATE ${currentState.value}")

            }, painterResource(id = R.drawable.ic_play_arrow),
            painterResource(id = R.drawable.ic_stop)
        )
    }
}