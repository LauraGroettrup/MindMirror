package com.fh.joanneum.mindmirror.analysis

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.R
import com.fh.joanneum.mindmirror.model.ConventionalSession
import kotlinx.android.synthetic.main.cross.*

class Cross : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cross)

        if(CreativeSession.getAnswer3().equals("")){
            Log.d("CROSS", "There was no creative answer")
            tVSubjectiveSituation.setText(ConventionalSession.getA2())
        }
        else{
            Log.d("CROSS", "There was a creative answer")
            //get data from model
            var answer3 = CreativeSession.getAnswer3()
            //textView setText
            tVSubjectiveSituation.text = CreativeSession.getAnswer3()
        }

        btnYes.setOnClickListener {
            val intent = Intent(this, SolutionFinding1::class.java)
            CreativeSession.setAnswer4(true)
            startActivity(intent)
        }

        btnNo.setOnClickListener {
            val intent = Intent(this, EarlyEnd::class.java)
            startActivity(intent)
        }
    }
}