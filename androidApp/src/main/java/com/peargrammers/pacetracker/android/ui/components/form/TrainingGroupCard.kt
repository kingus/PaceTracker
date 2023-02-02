package com.peargrammers.pacetracker.android.ui.components.form

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.peargrammers.pacetracker.android.R
import com.peargrammers.pacetracker.android.ui.components.custom.buttons.CircleButton
import com.peargrammers.pacetracker.android.ui.components.custom.input.NumberTextField
import com.peargrammers.pacetracker.android.ui.components.training.TrainingStageComponent
import com.peargrammers.pacetracker.android.ui.theme.*
import com.peargrammers.pacetracker.domain.models.TrainingGroup
import com.peargrammers.pacetracker.domain.models.TrainingStage
import com.peargrammers.pacetracker.presentation.TrainingPresenter
import org.koin.androidx.compose.get

@Composable
fun TrainingGroupCard(
    trainingGroup: TrainingGroup,
    onClickItem: () -> Unit,
    trainingViewModel: TrainingPresenter = get()
) {

    Card(
        modifier = Modifier
            .padding(MaterialTheme.spacing.small)
            .fillMaxWidth(),
        shape = RoundedCornerShape(MaterialTheme.spacing.medium),
        backgroundColor = LightGrey
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(),
        ) {
            Text(
                text = "GROUP ${trainingGroup.repeat}",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp),
                color = DarkBlue
            )

            trainingGroup.stages.forEach {
                TrainingStageComponent(
                    it, onClickItem
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                NumberTextField(trainingGroup.repeat.toString(), "x")

                CircleButton(
                    onClick = {
                        trainingViewModel.addStage(
                            trainingGroup,
                            TrainingStage(99L, 5f, 4f, 4L)
                        )
                    },
                    modifier = Modifier
                        .padding(10.dp)
                        .size(50.dp),
                    image = painterResource(R.drawable.ic_add)
                )
            }
            Spacer(modifier = Modifier.size(10.dp))
        }
    }
}