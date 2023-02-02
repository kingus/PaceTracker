package com.peargrammers.pacetracker.android

import com.peargrammers.pacetracker.android.data.repository.TrainingRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        TrainingRepository()
    }

    viewModel { TrainingViewModel(get()) }
}