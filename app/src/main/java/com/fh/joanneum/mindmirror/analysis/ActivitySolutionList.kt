package com.ug.mirrorapp.control

import Solution
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.ug.mirrorapp.R

class ActivitySolutionList () : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solution_list)

        //data
        var items = arrayOf("spazieren", "reden", "tanzen", "singen", "Serien schauen", "mit dem Hund spazieren gehen", "telefonieren")

        //adapter
        val solutionsAdapter = ArrayAdapter(this, R.layout.row, R.id.tVItem, items)

        //listView
        val listView = findViewById<ListView>(R.id.lVSolutionList)

        //connect adapter to ListView
        listView.setAdapter(solutionsAdapter)


    }
}




























