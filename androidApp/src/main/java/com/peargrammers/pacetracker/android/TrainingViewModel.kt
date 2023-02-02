package com.peargrammers.pacetracker.android

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peargrammers.pacetracker.android.data.repository.TrainingRepository
import com.peargrammers.pacetracker.android.service.LocationService

class TrainingViewModel (repository: TrainingRepository) : ViewModel() {
    private var _serviceState: MutableLiveData<LocationService.State> = repository.serviceState
    val serviceState: MutableLiveData<LocationService.State> = _serviceState

    private var _pace: MutableLiveData<String> = repository.pace
    val pace: MutableLiveData<String> = _pace

    private var _distance: MutableLiveData<Float> = repository.distance
    val distance: MutableLiveData<Float> = _distance
}