package com.fh.joanneum.mindmirror.creativepath

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.R
import com.fh.joanneum.mindmirror.analysis.Cross
import kotlinx.android.synthetic.main.situation_analysis.*

class SituationAnalysis : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.situation_analysis)

        btnContinue.setOnClickListener {
            val intent = Intent(this, Cross::class.java)
            startActivity(intent)
        }
    }
}