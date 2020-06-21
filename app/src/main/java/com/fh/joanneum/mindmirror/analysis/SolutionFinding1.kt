package com.fh.joanneum.mindmirror.analysis

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.R
import com.fh.joanneum.mindmirror.model.Analysis
import kotlinx.android.synthetic.main.solution_finding_1.*

class SolutionFinding1 : AppCompatActivity() {

    lateinit var solution: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.solution_finding_1)

        btnContinue.setOnClickListener {
            solution = eTMoodChangeSolution.text.toString()

            //add solution to model
            Analysis.setSolution(solution)

            val intent = Intent(this, SolutionFinding2::class.java)
            startActivity(intent)
        }
    }
}