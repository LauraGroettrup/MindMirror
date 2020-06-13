package com.fh.joanneum.mindmirror.conventionalpath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fh.joanneum.mindmirror.R
import com.fh.joanneum.mindmirror.analysis.Cross
import com.fh.joanneum.mindmirror.analysis.SituationAnalysis
import com.fh.joanneum.mindmirror.model.ConventionalSession

import kotlinx.android.synthetic.main.emotion_confirmation.*

class EmotionConfirmation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emotion_confirmation)

        lblSelection.setText(getString(R.string.emotion_selection, ConventionalSession.emotionsToString() ))

        btnConfirm.setOnClickListener {
            val intent = Intent(this, SituationAnalysis::class.java)
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            val intent = Intent(this, EmotionWordSelection::class.java)
            startActivity(intent)
        }
    }
}
