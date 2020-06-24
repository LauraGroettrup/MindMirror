package com.fh.joanneum.mindmirror.model

object Analysis {
    private var situation: String = ""
    private var changeMood: Boolean = false
    private var solutions = mutableListOf<String>()
    private var chosenSolution: String = ""

    fun setSituation(events_: String) {
        this.situation = events_
    }

    fun getSituation(): String {
        return situation
    }

    fun setChangeMood(changeMood_: Boolean) {
        this.changeMood = changeMood_
    }

    fun getChangeMood(): Boolean {
        return changeMood
    }

    fun setSolution(solution: String) {
        if (!solutions.contains(solution)) {
            solutions.add(solution)
        }
    }

    fun getSolutions(): MutableList<String> {
        return solutions
    }

    fun setChosenSolution(chosenOne: String) {
        chosenSolution = chosenOne
    }

    fun getChosenSolution(): String {
        return chosenSolution
    }

    fun clear() {
        situation = ""
        changeMood = false
        solutions.clear()
        chosenSolution = ""
    }
}