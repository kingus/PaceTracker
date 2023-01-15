package com.peargrammers.pacetracker.android.data.repository

import androidx.lifecycle.MutableLiveData
import com.peargrammers.pacetracker.android.service.LocationService

class TrainingRepository {

    val serviceState = MutableLiveData<LocationService.State>()
    val pace = MutableLiveData<String>()
    val distance = MutableLiveData<Float>()

}