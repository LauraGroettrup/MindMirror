package com.fh.joanneum.mindmirror.analysis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.fh.joanneum.mindmirror.R
import com.fh.joanneum.mindmirror.model.Analysis

class ActivitySolutionList () : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solution_list)

        //get data
        var items = Analysis.getSolutions()

        //adapter
        val solutionsAdapter = ArrayAdapter(this, R.layout.row, R.id.tVItem, items)

        //listView
        val listView = findViewById<ListView>(R.id.lVSolutionList)

        //connect adapter to ListView
        listView.setAdapter(solutionsAdapter)



        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->

                Analysis.setChosenSolution(parent.getItemAtPosition(position).toString())
                val intent = Intent(this, End::class.java)
                startActivity(intent)
        }
    }
}




























