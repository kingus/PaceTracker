package com.peargrammers.pacetracker.domain.Stage

data class Stage(
    val id: Long?,
    val targetPace: Long,
    val distance: Long,
    val statusFrequency: Long,
    val repeat: Long,
)
