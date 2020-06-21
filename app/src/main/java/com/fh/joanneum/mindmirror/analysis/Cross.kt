package com.fh.joanneum.mindmirror.analysis

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.R
import com.fh.joanneum.mindmirror.model.Analysis
import kotlinx.android.synthetic.main.cross.*

class Cross : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cross)

        tVSubjectiveSituation.setText(Analysis.getSituation())

        btnYes.setOnClickListener {
            val intent = Intent(this, SolutionFinding1::class.java)
            Analysis.setChangeMood(true)
            startActivity(intent)
        }

        btnNo.setOnClickListener {
            val intent = Intent(this, EarlyEnd::class.java)
            Analysis.setChangeMood(false)
            startActivity(intent)
        }
    }
}