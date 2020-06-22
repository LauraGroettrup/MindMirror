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
import com.fh.joanneum.mindmirror.model.ConventionalSession
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.end.*

class End : AppCompatActivity() {
    val db = Firebase.firestore
    var sessionDocRef: DocumentReference = FirebaseFirestore.getInstance().document("sessions/session")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.end)

        //get data from model
        var chosenSolution = Analysis.getChosenSolution()
        //textView setText
        lblOptions.text = chosenSolution
        // save sessionData to DB
        saveSessionData()

        btnBackToMain.setOnClickListener {
            val intent = Intent(this, PathSelection::class.java)
            startActivity(intent)
        }
    }

    fun saveSessionData(){
        val session = hashMapOf(
            "situation" to Analysis.getSituation(),
            "changeMood" to Analysis.getChangeMood(),
            "chosenSolution" to Analysis.getChosenSolution(),
            "solutions" to  Analysis.getSolutions()
        )
        if (!CreativeSession.getPicture().equals("")){
            session.put("picture",CreativeSession.getPicture())
            session.put("picExpression",CreativeSession.getPicExpression())
        } else {
            session.put("emotions", ConventionalSession.getEmotions())
        }
        
        db.collection("users").document(Firebase.auth.currentUser!!.uid).collection("sessions")
            .add(session)
            .addOnSuccessListener { documentReference ->
                Log.d("Message", "DocumentSnapShot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener{e ->
                Log.e("Message", "Error adding document", e)
            }
    }
}