package com.peargrammers.pacetracker.data.local

import com.peargrammers.pacetracker.database.PaceTrackerDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(PaceTrackerDatabase.Schema, "pacetracker.db")
    }
}