package com.peargrammers.pacetracker.android.ui.components.training

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.observe
import com.peargrammers.pacetracker.android.TrainingViewModel
import com.peargrammers.pacetracker.android.R
import com.peargrammers.pacetracker.android.ui.components.custom.texts.TextWithIcon
import com.peargrammers.pacetracker.android.ui.theme.*

@Composable
fun TimeDistanceCard(viewModel: TrainingViewModel) {

    val distanceValue = remember { mutableStateOf(viewModel.distance.value) }

    viewModel.distance.observe(LocalLifecycleOwner.current) { state ->
        distanceValue.value = state
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(MaterialTheme.spacing.medium),
        shape = RoundedCornerShape(MaterialTheme.spacing.extraLarge),
        backgroundColor = Color.White,
        elevation = 1.dp,
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            verticalAlignment = CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            ColumnItem("Time", "00:00:01", modifier = Modifier.weight(1f), R.drawable.ic_timer)
            Divider(
                modifier = Modifier
                    .height(120.dp)
                    .width(1.dp),
                color = LightGrey

            )
            ColumnItem("Distance", "0", modifier = Modifier.weight(1f), R.drawable.ic_walk)

        }
    }
}

@Composable
fun ColumnItem(label: String, value: String, modifier: Modifier, icon: Int) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxHeight()
            .padding(10.dp)
    ) {
        TextWithIcon(label = label, icon)
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = value,
                style = MaterialTheme.typography.h2,
            )
        }
    }
}