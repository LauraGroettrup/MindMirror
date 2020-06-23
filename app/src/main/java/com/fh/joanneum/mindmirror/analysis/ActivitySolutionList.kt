package com.fh.joanneum.mindmirror.analysis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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




























