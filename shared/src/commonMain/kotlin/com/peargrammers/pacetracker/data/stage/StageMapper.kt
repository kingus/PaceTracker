package com.peargrammers.pacetracker.data.stage

import com.peargrammers.pacetracker.database.StageEntity
import com.peargrammers.pacetracker.domain.Stage.Stage

fun StageEntity.toStage(): Stage {
    return Stage(
        id = id,
        targetPace = targetPace,
        distance = distance,
        statusFrequency = statusFrequency,
        repeat = repeat
    )
}