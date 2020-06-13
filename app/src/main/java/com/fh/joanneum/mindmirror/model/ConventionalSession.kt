package com.fh.joanneum.mindmirror.model

object ConventionalSession {
    private var emotions: MutableList<String> = mutableListOf("")
    private var a2: String = ""
    private var a3: Boolean = false
    private var solutions: MutableList<String> = mutableListOf("")

    fun getEmotions(): List<String>{
        return emotions
    }
    fun setEmotions(emotion: String){
        if(!emotions.contains(emotion)){
            emotions.add(emotion)
        }
        else{
            emotions.remove(emotion)
        }
    }

    fun getA2(): String {
        return a2
    }
    fun setA2(a2:String){
        this.a2 = a2
    }

    fun getA3():Boolean{
        return a3
    }
    fun setA3(a3:Boolean){
        this.a3 = a3
    }

    fun getSolutions(): List<String>{
        return solutions
    }
    fun setSolutions(solution: String){
        if(!solutions.contains(solution)){
            solutions.add(solution)
        }
        else{
            solutions.remove(solution)
        }
    }

    fun emotionsToString(): String{
        var emotionsAsString = ""
        for (emotion in emotions){
            emotionsAsString = emotionsAsString + emotion + ","
        }
        return emotionsAsString
    }

}