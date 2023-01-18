package com.peargrammers.pacetracker.data.local

import android.content.Context
import com.peargrammers.pacetracker.data.stage.SqlDelightSatgeDataSource
import com.peargrammers.pacetracker.database.PaceTrackerDatabase
import com.peargrammers.pacetracker.domain.Stage.StageDataSource
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(PaceTrackerDatabase.Schema, context, "pacetracker.db")
    }
}