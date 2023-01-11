package com.peargrammers.pacetracker.android.ui.components.training

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.peargrammers.pacetracker.android.R
import com.peargrammers.pacetracker.android.ui.theme.*

@Composable
fun TimeDistanceCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(MaterialTheme.spacing.medium),
        shape = RoundedCornerShape(MaterialTheme.spacing.extraLarge),
        backgroundColor = LightGrey,
        elevation = 1.dp,
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.5f)
                    .fillMaxHeight()
                    .padding(10.dp)

            ) {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_timer),
                        "Info",
                        modifier = Modifier
                            .padding(MaterialTheme.spacing.small)
                            .size(16.dp)
                    )
                    Text(
                        text = "Time",
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.align(CenterVertically)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "00:00:00",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h2,
                    )
                }

            }
            Divider(
                modifier = Modifier
                    .height(190.dp)
                    .width(1.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_timer),
                        "Info",
                        modifier = Modifier
                            .padding(MaterialTheme.spacing.small)
                            .size(16.dp)
                    )
                    Text(
                        text = "Distance",
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.align(CenterVertically)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "5 km",
                        style = MaterialTheme.typography.h2,
                    )
                }

            }

        }
    }
}