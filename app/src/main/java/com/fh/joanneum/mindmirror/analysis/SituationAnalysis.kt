package com.fh.joanneum.mindmirror.analysis

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.R
import com.fh.joanneum.mindmirror.model.ConventionalSession
import kotlinx.android.synthetic.main.situation_analysis.*

class SituationAnalysis : AppCompatActivity() {

    lateinit var answer3: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.situation_analysis)

        //get data from model
        var answer2 = CreativeSession.getAnswer2()
        val creative = !answer2.equals("")
        //textView
        val presentText = findViewById<TextView>(R.id.tVPicSubjectiveMeaning)

        if(creative){
            //setText
            presentText.text = answer2

        }
        else{
            tVPicMeaning.text = "Du fühlst dich gerade: "
            presentText.text = ConventionalSession.emotionsToString()
        }

        btnContinue.setOnClickListener {
            if(creative){
                answer3 = eTReasonSituation.text.toString()
                //save data to model
                CreativeSession.setAnswer3(answer3)
            }
            else
                ConventionalSession.setA2(eTReasonSituation.text.toString())

            val intent = Intent(this, Cross::class.java)
            startActivity(intent)
        }
    }
}