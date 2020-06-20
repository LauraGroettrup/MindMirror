object CreativeSession {
    //private var path: String = ""
    private var picture: Int = -1
    private var answer2: String = ""
    private var answer3: String = ""
    private var answer4: Boolean = false
    private var solutions: MutableList<String> = mutableListOf()
    private var chosenSolution: String = ""


    fun getPicture(): Int {
        return picture
    }

    fun setPicture(pic: Int) {
        this.picture = pic
    }

    fun getAnswer2():String{
        return answer2
    }

    fun setAnswer2(answer: String){
        this.answer2 = answer
    }

    fun getAnswer3():String{
        return answer3
    }

    fun setAnswer3(answer: String){
        this.answer3 = answer
    }

    fun getAnswer4():Boolean{
        return answer4
    }

    fun setAnswer4(answer: Boolean){
        this.answer4 = answer
    }


    fun getSolutions(): List<String> {
        return solutions
    }

    fun setSolutions(solution: String) {
        if (!solutions.contains(solution)) {
            solutions.add(solution)
        } else {
            solutions.remove(solution)
        }
    }

    fun setChosenSolution(solution:String){
        this.chosenSolution = solution
    }

    fun getChosenSolution(): String{
        return chosenSolution
    }

}