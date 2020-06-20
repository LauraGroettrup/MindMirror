package com.fh.joanneum.mindmirror.model

object Analysis {
    private var events: String = ""
    private var changeMood: Boolean = false
    private var solutions: MutableList<String> = mutableListOf("")
    private var choosenSolution: String = ""

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

    fun setChoosenSolution(choosenOne:String){
        choosenSolution = choosenOne
    }

    fun getChoosenSolution(): String{
        return choosenSolution
    }

    fun clear(){
        events = ""
        changeMood = false
        solutions = mutableListOf("")
        choosenSolution = ""
    }
}