package com.peargrammers.pacetracker.android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.peargrammers.pacetracker.android.ui.components.custom.buttons.CustomButton
import com.peargrammers.pacetracker.android.ui.components.form.TrainingGroupCard
import com.peargrammers.pacetracker.domain.models.Training
import com.peargrammers.pacetracker.presentation.TrainingPresenter
import org.koin.androidx.compose.get

@Composable
fun TrainingFormScreen(
    trainingViewModel: TrainingPresenter = get()
) {

    val training = trainingViewModel.training.collectAsState()
    val num by trainingViewModel.myNum.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = num.toString(),
            style = MaterialTheme.typography.body1
        )

        TrainingComponent(training, {})
        CustomButton(
            onClick = {
                println(num.toString())
                trainingViewModel.editNum(4)
            },
            label = "Go to run"
        )
    }
}

@Composable
fun TrainingComponent(
    training: State<Training>,
    onClickItem: () -> Unit,
) {
    LazyColumn(
    ) {
        items(items = training.value.groups, itemContent = { item ->
            TrainingGroupCard(
                item, onClickItem
            )
        })
    }
}