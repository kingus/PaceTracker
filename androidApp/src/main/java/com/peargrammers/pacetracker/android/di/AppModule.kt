package com.peargrammers.pacetracker.android.di

import android.content.Context
import com.google.android.gms.location.LocationServices
import com.peargrammers.pacetracker.android.data.repository.TrainingRepository
import com.peargrammers.pacetracker.android.location.DefaultLocationClient
import com.peargrammers.pacetracker.android.service.LocationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocationService(
    ) = LocationService()

    @Provides
    @Singleton
    fun provideTrainingRepository(
    ) = TrainingRepository()

    @Provides
    @Singleton
    fun provideLocationClient(
        @ApplicationContext applicationContext: Context
    ) = DefaultLocationClient(
        applicationContext,
        LocationServices.getFusedLocationProviderClient(applicationContext)
    )
}