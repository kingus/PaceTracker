package com.peargrammers.pacetracker.android.permissions

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

class PermissionsValidator {
    companion object {
        fun locationPermissions(): List<String> = listOf(
            ACCESS_FINE_LOCATION,
            ACCESS_COARSE_LOCATION
        )

        fun isPermissionGranted(
            context: Context,
            permission: String
        ): Boolean {
            return ContextCompat.checkSelfPermission(
                context,
                permission
            ) == PackageManager.PERMISSION_GRANTED
        }

        fun isPermissionGranted(
            context: Context,
            permission: List<String>
        ): Boolean {
            return permission.all { eachPermission ->
                ContextCompat.checkSelfPermission(
                    context,
                    eachPermission
                ) == PackageManager.PERMISSION_GRANTED
            }
        }
    }
}