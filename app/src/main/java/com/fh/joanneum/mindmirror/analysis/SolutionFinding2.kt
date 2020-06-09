package com.fh.joanneum.mindmirror.analysis

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.R
import kotlinx.android.synthetic.main.solution_finding_2.*

class SolutionFinding2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.solution_finding_2)

        btnYes.setOnClickListener {
            val intent = Intent(this, SolutionFinding2::class.java)
            startActivity(intent)
        }

        btnNo.setOnClickListener {
            val intent = Intent(this, SolutionList::class.java)
            startActivity(intent)
        }
    }
}