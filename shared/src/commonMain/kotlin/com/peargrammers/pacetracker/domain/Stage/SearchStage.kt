package com.peargrammers.pacetracker.domain.Stage

class SearchStage {

    fun execute(stages: List<Stage>, query: String): List<Stage> {
        if (query.isBlank()) {
            return stages
        }
        return stages.filter {
            it.id.toString().contains(query.lowercase())
        }
    }
}