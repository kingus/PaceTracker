package com.peargrammers.pacetracker.android.utils

import android.location.Location

class LocationConverter {
    companion object {
        fun calculateDistance(startLocation: Location, endLocation: Location): Float {
            return startLocation.distanceTo(endLocation)
        }

        fun calculateSpeedMetersPerSecond(
            currentDistanceInMeters: Float,
            intervalInMiliseconds: Long
        ): Float {
            return (currentDistanceInMeters / intervalInMiliseconds) * 1000
        }

        fun convertSpeedToKilometersPerHour(speedInMetersPerSecond: Float): Double {
            return speedInMetersPerSecond * 3.6
        }
    }
}