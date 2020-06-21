import android.net.Uri
import com.google.firebase.storage.StorageReference

object CreativeSession {
    //private var path: String = ""
    private lateinit var picture: StorageReference
    private var answer2: String = ""



    fun getPicture(): StorageReference {
        return picture
    }

    fun setPicture(pic: StorageReference) {
        this.picture = pic
    }

    fun getAnswer2():String{
        return answer2
    }

    fun setAnswer2(answer: String){
        this.answer2 = answer
    }
}