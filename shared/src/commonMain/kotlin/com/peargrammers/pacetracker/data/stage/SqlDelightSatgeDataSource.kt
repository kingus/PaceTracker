package com.peargrammers.pacetracker.data.stage

import com.peargrammers.pacetracker.database.PaceTrackerDatabase
import com.peargrammers.pacetracker.domain.Stage.Stage
import com.peargrammers.pacetracker.domain.Stage.StageDataSource

class SqlDelightSatgeDataSource(db: PaceTrackerDatabase): StageDataSource {

    private val queries = db.pacetrackerQueries

    override suspend fun getAllStages(): List<Stage> {
        return queries.getAllStages().executeAsList().map { it.toStage() }
    }

    override suspend fun getStageById(id: Long): Stage? {
        return queries
            .getStageById(id)
            .executeAsOneOrNull()
            ?.toStage()
    }

    override suspend fun insertStage(stage: Stage) {
        queries.insertStage(stage.id, stage.targetPace, stage.distance, stage.statusFrequency, stage.repeat)
    }

    override suspend fun deleteStageById(id: Long) {
        queries.deleteStageById(id)
    }

}