package com.fh.joanneum.mindmirror.analysis

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.MainActivity
import com.fh.joanneum.mindmirror.R
import com.fh.joanneum.mindmirror.conventionalpath.EmotionWordSelection
import com.fh.joanneum.mindmirror.creativepath.PictureExpression
import com.fh.joanneum.mindmirror.model.Analysis
import com.fh.joanneum.mindmirror.model.ConventionalSession
import com.fh.joanneum.mindmirror.model.CreativeSession
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.situation_analysis.*

class SituationAnalysis : AppCompatActivity() {

    lateinit var answer3: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.situation_analysis)

        //get data from model
        var answer2 = CreativeSession.getPicExpression()
        val creative = !answer2.equals("")
        //textView
        val presentText = findViewById<TextView>(R.id.tVPicSubjectiveMeaning)

        if (creative) {
            //setText
            presentText.text = answer2

        } else {
            tVPicMeaning.text = "Du fühlst dich gerade: "
            presentText.text = ConventionalSession.emotionsToString()
        }

        btnContinue.setOnClickListener {
            Analysis.setSituation(eTReasonSituation.text.toString())
            val intent = Intent(this, Cross::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appmenu, menu)
        return true
    }

    override fun onBackPressed() {
        if (!CreativeSession.getPicture().equals("")) {
            val intent = Intent(this, PictureExpression::class.java)
            startActivity(intent)

        } else {
            val intent = Intent(this, EmotionWordSelection::class.java)
            startActivity(intent)
        }
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