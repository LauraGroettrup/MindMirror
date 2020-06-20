object CreativeSession {
    private var picture: Int = -1
    private var answer2: String = ""

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
}