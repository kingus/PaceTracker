package com.peargrammers.pacetracker.domain.models

data class TrainingStage(
    val id: Long?,
    val targetPace: Float,
    val distance: Float,
    val statusFrequency: Long
)