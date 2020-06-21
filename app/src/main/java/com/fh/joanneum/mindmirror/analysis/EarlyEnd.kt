package com.fh.joanneum.mindmirror.analysis

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.MainActivity
import com.fh.joanneum.mindmirror.PathSelection
import com.fh.joanneum.mindmirror.R
import com.fh.joanneum.mindmirror.model.Analysis
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.early_end.*

class EarlyEnd : AppCompatActivity() {

    var picMap: MutableMap<String, String> = mutableMapOf()
    val db = Firebase.firestore
    var sessionDocRef: DocumentReference = FirebaseFirestore.getInstance().document("sessions/session")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.early_end)

        lblGoodbye.text = getString(R.string.goodbye, User.getUsername())

        fun saveSelectedPic() {
            var selectedPic = CreativeSession.getPicture()
            picMap.put("selected Pic", selectedPic)
            sessionDocRef.set(picMap)
                .addOnSuccessListener {
                    Log.d("Selected Pic", "Pic has been saved.")}
                .addOnFailureListener {
                    Log.d("Selected Pic", "Document was not saved")
            }
        }

        fun saveSessionData(){
            val session = hashMapOf(
                "picture" to CreativeSession.getPicture(),
                "picExpression" to CreativeSession.getPicExpression(),
                "situation" to Analysis.getSituation(),
                "changeMood" to Analysis.getChangeMood(),
                "chosenSolution" to Analysis.getChosenSolution(),
                "solutions" to  Analysis.getSolutions()
            )
            db.collection("sessions")
                .add(session)
                .addOnSuccessListener { documentReference ->
                    Log.d("Message", "DocumentSnapShot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener{e ->
                    Log.w("Message", "Error adding document", e)
                }
        }

        btnBackToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
           startActivity(intent)
        }

        btnLogout.setOnClickListener {
            //saveSelectedPic()
            saveSessionData()
            Firebase.auth.signOut()
            Toast.makeText(baseContext, "You are logged out.",
            Toast.LENGTH_SHORT
            ).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

