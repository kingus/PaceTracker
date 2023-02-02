package com.peargrammers.pacetracker.domain.models

data class TrainingGroup(
    val stages: MutableList<TrainingStage>,
    val repeat: Int,
)