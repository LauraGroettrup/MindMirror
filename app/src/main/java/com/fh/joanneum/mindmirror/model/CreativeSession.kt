object CreativeSession {
    private var picture: Int = -1
    private var a2: String = ""
    private var a3: String = ""
    private var a4: Boolean = false
    private var solutions: MutableList<String> = mutableListOf("")

    fun getPicture(): Int {
        return picture
    }

    fun setPicture(pic: Int) {
        this.picture = pic
    }

    fun geta2(): String {
        return a2
    }

    fun seta2(a2: String) {
        this.a2 = a2
    }

    fun geta3(): String {
        return a3
    }

    fun seta3(a3: String) {
        this.a3 = a3
    }

    fun geta4(): Boolean {
        return a4
    }

    fun seta4(a4: Boolean) {
        this.a4 = a4
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

}