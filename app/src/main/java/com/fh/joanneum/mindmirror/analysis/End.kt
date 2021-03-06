package com.fh.joanneum.mindmirror.analysis

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.MainActivity
import com.fh.joanneum.mindmirror.PathSelection
import com.fh.joanneum.mindmirror.R
import com.fh.joanneum.mindmirror.model.Analysis
import com.fh.joanneum.mindmirror.model.ConventionalSession
import com.fh.joanneum.mindmirror.model.CreativeSession
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.end.*

class End : AppCompatActivity() {
    val db = Firebase.firestore
    var sessionDocRef: DocumentReference =
        FirebaseFirestore.getInstance().document("sessions/session")

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

    fun saveSessionData() {
        val session = hashMapOf(
            "situation" to Analysis.getSituation(),
            "changeMood" to Analysis.getChangeMood(),
            "chosenSolution" to Analysis.getChosenSolution(),
            "solutions" to Analysis.getSolutions()
        )
        if (!CreativeSession.getPicture().equals("")) {
            session.put("picture", CreativeSession.getPicture())
            session.put("picExpression", CreativeSession.getPicExpression())
        } else {
            session.put("emotions", ConventionalSession.getEmotions())
        }

        db.collection("users").document(Firebase.auth.currentUser!!.uid).collection("sessions")
            .add(session)
            .addOnSuccessListener { documentReference ->
                Log.d("Message", "DocumentSnapShot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.e("Message", "Error adding document", e)
            }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.actionLogout -> {
                Firebase.auth.signOut()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }

}