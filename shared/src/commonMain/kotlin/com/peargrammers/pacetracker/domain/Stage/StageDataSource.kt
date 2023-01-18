package com.peargrammers.pacetracker.domain.Stage

interface StageDataSource {
    suspend fun getAllStages(): List<Stage>
    suspend fun getStageById(id: Long): Stage?
    suspend fun insertStage(stage: Stage)
    suspend fun deleteStageById(id: Long)

}