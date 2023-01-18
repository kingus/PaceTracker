package com.peargrammers.pacetracker.android.ui.components.form

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.peargrammers.pacetracker.android.ui.components.training.AddPeriodRowItem
import com.peargrammers.pacetracker.android.ui.components.training.PeriodItem
import com.peargrammers.pacetracker.android.ui.theme.LightGrey
import com.peargrammers.pacetracker.android.ui.theme.spacing
import com.peargrammers.pacetracker.domain.models.RunPeriod

@Composable
fun TrainingGroupCard(onClickItem: () -> Unit) {
    Card(
        modifier = Modifier.padding(MaterialTheme.spacing.small),
        shape = RoundedCornerShape(MaterialTheme.spacing.medium),
        backgroundColor = LightGrey,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Group I",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
            )

            RunLazyColumn(
                list = listOf(
                    RunPeriod(10.0f, 7.6f, "HIGH"),
                    RunPeriod(1.0f, 2.6f, "LOW"),
                    RunPeriod(5.0f, 4.6f, "MEDIUM")
                ), onClickItem
            )
            AddPeriodRowItem(modifier = Modifier)

            Spacer(modifier = Modifier.size(10.dp))
        }
    }
}

@Composable
fun RunLazyColumn(list: List<RunPeriod>, onClickItem: () -> Unit) {
    LazyColumn(
    ) {
        items(items = list, itemContent = { item ->
            PeriodItem(
                item, onClickItem
            )
        })
    }
}