package com.peargrammers.pacetracker.di


import com.peargrammers.pacetracker.presentation.TrainingPresenter
import org.koin.dsl.module

val commonModule = module {
    single { TrainingPresenter() }
}