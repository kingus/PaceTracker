package com.peargrammers.pacetracker.di

import com.peargrammers.pacetracker.presentation.TrainingPresenter
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(enableNetworkLogs: Boolean = false, appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(commonModule)
    }

fun KoinApplication.Companion.start(): KoinApplication = initKoin { }

val Koin.trainingPresenter: TrainingPresenter
    get() = get()
