import android.net.Uri

object CreativeSession {

    private lateinit var picture:String
    private var picExpression: String = ""



    fun getPicture(): String {
        return picture
    }

    fun setPicture(pic: String) {
        this.picture = pic
    }

    fun getPicExpression():String{
        return picExpression
    }

    fun setAnswer2(answer: String){
        this.picExpression = answer
    }

    fun clear(){
        picExpression = ""
        picture = ""
    }
}