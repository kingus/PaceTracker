package com.peargrammers.pacetracker.android.ui.components.profile

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
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.peargrammers.pacetracker.android.ui.components.RoundImage
import com.peargrammers.pacetracker.android.ui.theme.spacing
import com.peargrammers.pacetracker.android.R
import com.peargrammers.pacetracker.android.ui.components.training.PeriodItemDivider
import com.peargrammers.pacetracker.android.ui.theme.IntenseOrange

@Composable
fun RecentActivityItemWithDate() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 0.dp)
    ) {
        TimelineDivider()
        Column(horizontalAlignment = CenterHorizontally) {

            Text(
                text = "Today",
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(10.dp, 0.dp)
            )
            ActivityCard()
        }
    }
}

@Composable
fun RecentActivityItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 0.dp)
    ) {
        TimelineDivider(Modifier.height(30.dp))
        Column(horizontalAlignment = CenterHorizontally) {
            ActivityCard()
        }
    }
}

@Composable
fun ActivityCard() {
    Card(
        modifier = Modifier
            .height(80.dp)
            .padding(MaterialTheme.spacing.small, MaterialTheme.spacing.extraSmall)
            .clickable {},
        shape = RoundedCornerShape(MaterialTheme.spacing.medium),
        backgroundColor = Color.White,
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp, 10.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AddRow(label = "DISTANCE", value = "10", "KM")
            PeriodItemDivider(modifier = Modifier.align(Alignment.CenterVertically))
            AddRow(label = "TIME", value = "0:45:21")
            PeriodItemDivider(modifier = Modifier.align(Alignment.CenterVertically))
            AddRow(label = "PACE", value = "8.12", unit = "KPH")
        }
    }
}

@Composable
fun AddRow(label: String, value: String, unit: String? = null) {
    Column(
        modifier = Modifier.padding(15.dp, 2.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.h5,
            color = IntenseOrange,
        )
        Row(
            verticalAlignment = Bottom, horizontalArrangement = Arrangement.Center

        ) {
            Text(
                text = value,
                style = MaterialTheme.typography.h4,
            )
            if (unit != null) {
                Text(
                    text = unit,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(2.dp, 1.dp)
                )
            }
        }
    }
}

@Composable
fun TimelineDivider(modifier: Modifier = Modifier.height(50.dp)) {
    Column(horizontalAlignment = CenterHorizontally) {
        Divider(
            color = IntenseOrange,
            modifier = modifier
                .width(2.dp)
        )
        RoundImage(
            image = painterResource(id = R.drawable.ic_walk),
            Modifier.size(25.dp),
            Modifier.padding(4.dp),
            IntenseOrange,
            Color.White
        )
        Divider(
            color = IntenseOrange,
            modifier = Modifier
                .height(30.dp)
                .width(2.dp)
        )
    }
}