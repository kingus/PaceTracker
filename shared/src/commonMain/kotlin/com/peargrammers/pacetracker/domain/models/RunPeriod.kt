package com.peargrammers.pacetracker.domain.models

data class RunPeriod(
    val distance: Float,
    val targetPace: Float,
    val paceStatus: String)