package com.peargrammers.pacetracker.android.ui.components.training

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.peargrammers.pacetracker.android.R
import com.peargrammers.pacetracker.android.ui.components.custom.buttons.CircleButton
import com.peargrammers.pacetracker.android.ui.theme.*
import com.peargrammers.pacetracker.domain.models.RunPeriod

@Composable
fun PeriodItem(runPeriod: RunPeriod, onClickItem: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(MaterialTheme.spacing.small)
            .clickable{onClickItem()
                      println("BLA")
            },
        shape = RoundedCornerShape(MaterialTheme.spacing.medium),
        backgroundColor = Color.White,
        elevation = 1.dp,
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Center
        ) {
            PeriodRowItem(
                modifier = Modifier.weight(1f),
                value = runPeriod.distance.toString(),
                label = "DISTANCE",
                unit = "KM"
            )
            PeriodItemDivider(modifier = Modifier.align(CenterVertically))
            PeriodRowItem(
                modifier = Modifier.weight(1f),
                value = runPeriod.targetPace.toString(),
                label = "TARGET PACE",
                unit = "KM/H"
            )
            PeriodItemDivider(modifier = Modifier.align(CenterVertically))
            PeriodRowItem(
                modifier = Modifier.weight(1f),
                value = runPeriod.paceStatus,
                label = "PACE STATUS"
            )
        }
    }
}


@Composable
fun PeriodRowItem(modifier: Modifier, label: String, value: String, unit: String? = null) {
    Column(
        modifier = modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Row(
            verticalAlignment = CenterVertically,
            horizontalArrangement = Arrangement.Center

        ) {
            Text(
                text = value,
                style = MaterialTheme.typography.h2,
            )
            if (unit != null) {
                Text(
                    text = unit,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier
                        .padding(3.dp)
                        .align(Bottom),
                )
            }
        }
        Text(
            text = label,
            style = MaterialTheme.typography.h5,
            color = IntenseOrange

        )
    }
}

@Composable
fun AddPeriodRowItem(modifier: Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(MaterialTheme.spacing.small),
        shape = RoundedCornerShape(MaterialTheme.spacing.medium),
        backgroundColor = Color.White,
        elevation = 1.dp,
    ) {
        Column(
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircleButton(
                onClick = { },
                modifier = Modifier
                    .size(50.dp),
                image = painterResource(R.drawable.ic_add)
            )
        }

    }
}

@Composable
fun PeriodItemDivider(modifier: Modifier) {
    Divider(
        modifier = modifier
            .height(80.dp)
            .width(1.dp),
        color = LightGrey
    )
}