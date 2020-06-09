package com.fh.joanneum.mindmirror.conventionalpath

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.R
import kotlinx.android.synthetic.main.word_selection.*

class EmotionWordSelection : AppCompatActivity() {

    var adapter: EmotionWordAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_selection)

        adapter =
            EmotionWordAdapter(this)
        gridWordEmotions.adapter = adapter

        gridWordEmotions.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                Toast.makeText(
                    this@EmotionWordSelection,
                    " Clicked Emotion: " + parent.getItemAtPosition(position).toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }

        btnSubmit.setOnClickListener {
            val intent = Intent(this, EmotionConfirmation::class.java)
            startActivity(intent)
        }
    }
}