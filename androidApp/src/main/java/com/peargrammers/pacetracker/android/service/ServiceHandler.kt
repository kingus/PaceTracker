package com.peargrammers.pacetracker.android.service

import android.content.Context
import android.content.Intent

object ServiceHandler {
    fun triggerForegroundService(context: Context, action: String) {
        Intent(context, LocationService::class.java).apply {
            this.action = action
            context.startService(this)
        }
    }
}