package com.peargrammers.pacetracker.presentation

import com.peargrammers.pacetracker.domain.models.Training
import com.peargrammers.pacetracker.domain.models.TrainingGroup
import com.peargrammers.pacetracker.domain.models.TrainingStage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

class TrainingPresenter : KoinComponent {

    private val trainingMock = Training(
        mutableListOf(
            TrainingGroup(
                mutableListOf(
                    TrainingStage(1, 10.0f, 7.6f, 1),
                    TrainingStage(2, 1.0f, 2.6f, 1),
                ), 1
            ),
            TrainingGroup(
                mutableListOf(
                    TrainingStage(3, 4.0f, 0.2f, 1),
                ), 5
            )
        )
    )

    private val _training = MutableStateFlow<Training>(trainingMock)
    val training get() = _training.asStateFlow()

    private val _myNum = MutableStateFlow<Int>(0)
    val myNum get() = _myNum.asStateFlow()

    fun editNum(num: Int){
        _myNum.update { num }
    }

    fun addStage(trainingGroup: TrainingGroup, trainingStage: TrainingStage) {
        _training.update {
            it.apply {
                this.groups.find { it.repeat == trainingGroup.repeat }.apply {
                    this?.stages?.add(trainingStage)
                }
            }
        }
    }
}