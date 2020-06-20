package com.fh.joanneum.mindmirror.analysis

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.R
import com.fh.joanneum.mindmirror.model.Analysis
import kotlinx.android.synthetic.main.solution_finding_2.*

class SolutionFinding2 : AppCompatActivity() {

    lateinit var answer5: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.solution_finding_2)


        btnYes.setOnClickListener {
            answer5 = eTAnotherSolution.text.toString()
            //add answer5 to model (List)
            Analysis.setSolution(answer5)
            val intent = Intent(this, SolutionFinding2::class.java)
            startActivity(intent)
        }

        btnNo.setOnClickListener {
            answer5 = eTAnotherSolution.text.toString()
            //add answer5 to model (List)
            Analysis.setSolution(answer5)
            val intent = Intent(this, ActivitySolutionList::class.java)
            startActivity(intent)
        }
    }
}