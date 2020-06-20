package com.fh.joanneum.mindmirror.model

object Analysis {
    private var events: String = ""
    private var changeMood: Boolean = false
    private var solutions: MutableList<String> = mutableListOf("")
    private var chosenSolution: String = ""

    fun setEvents(events_: String){
        this.events = events_
    }
    fun getEvents(): String{
        return events
    }

    fun setChangeMood(changeMood_: Boolean){
        this.changeMood = changeMood_
    }
    fun getChangeMood(): Boolean{
        return changeMood
    }

    fun setSolution(solution: String){
        if(!solutions.contains(solution)){
            solutions.add(solution)
        }
    }

    fun getSolutions():MutableList<String>{
        return solutions
    }

    fun setChosenSolution(choosenOne:String){
        chosenSolution = choosenOne
    }

    fun getChosenSolution(): String{
        return chosenSolution
    }

    fun clear(){
        events = ""
        changeMood = false
        solutions = mutableListOf("")
        chosenSolution = ""
    }
}