package com.peargrammers.pacetracker.android.ui.components.training

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.observe
import com.peargrammers.pacetracker.android.TrainingViewModel
import com.peargrammers.pacetracker.android.R
import com.peargrammers.pacetracker.android.ui.components.custom.texts.TextWithIcon
import com.peargrammers.pacetracker.android.ui.theme.*

@Composable
fun PaceCard(viewModel: TrainingViewModel = hiltViewModel()) {

    val paceValue = remember { mutableStateOf(viewModel.pace.value) }

    viewModel.pace.observe(LocalLifecycleOwner.current) { state ->
        paceValue.value = state
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(MaterialTheme.spacing.medium),
        shape = RoundedCornerShape(MaterialTheme.spacing.extraLarge),
        backgroundColor = Color.White,
        elevation = 1.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp, 20.dp)
        ) {
            TextWithIcon(label = "Pace", icon = R.drawable.ic_speed)

            Text(
                text = paceValue.value ?: "0.0",
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "km/h",
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}